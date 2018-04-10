package pk.net.now.cornellmobileapp.data;

import android.util.Log;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import pk.net.now.cornellmobileapp.App;
import pk.net.now.cornellmobileapp.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientFactory {

    public static Retrofit getClient(String baseUrl) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        try {
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            sslContext.init(null, new TrustManager[] { trustManager }, null);
            builder.sslSocketFactory(sslContext.getSocketFactory(), trustManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if(BuildConfig.DEBUG)
        builder.addInterceptor(logging);
        builder.addInterceptor(chain -> {
            Request original = chain.request();

            //this is used for all requests
            final String token = App.prefs().getToken();
            if (token != null && !original.headers().names().contains("Authorization")) {
                if(BuildConfig.DEBUG)
                    Log.d("Auth",token);
                return chain.proceed(original.newBuilder()
                        .header("Authorization", token)
                        .build());
            }else {
                return chain.proceed(original);
            }
        });

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }
}