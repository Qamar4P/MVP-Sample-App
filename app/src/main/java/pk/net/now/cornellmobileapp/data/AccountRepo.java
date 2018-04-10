package pk.net.now.cornellmobileapp.data;

import android.util.Base64;
import java.util.HashMap;

import pk.net.now.cornellmobileapp.data.model.BaseResponse;
import pk.net.now.cornellmobileapp.data.model.UserModel;
import pk.net.now.cornellmobileapp.ui.shared.AppUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Qamar on 7/18/2017.
 */

public class AccountRepo extends BaseRepo {
    final String SERVICE_ROUTE = "https://beta.talkhomeapp.com/new/test/";
    private WebService service;

    private AccountRepo() {
        service = ApiClientFactory.getClient(SERVICE_ROUTE).create(WebService.class);
    }

    public void signUp(UserModel userModel, final DataCallBack callBack) {
        enqueueCall(service.signUp(userModel),callBack);
    }

    public void login(String email, String password, final DataCallBack callBack) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("Email",email);
        params.put("Password",password);
        //there are many way to get IP and different IPs
        params.put("IPAddress", AppUtils.getLocalIpAddress());
        Call<BaseResponse> login = service.login(params);
        // FIXME: 9/7/2017 use userId instead of email
        String token = "Basic "+ Base64.encodeToString((email+":"+password).getBytes(),Base64.DEFAULT).trim();
        login.request().newBuilder().addHeader("Authorization",token).build();
        enqueueCall(login,callBack);
    }

    interface WebService {

        // https://beta.talkhomeapp.com/auth/test/signup
        // https://beta.talkhomeapp.com/auth/test/login
        //https://beta.talkhomeapp.com/auth/test/topup
        @POST("signup")
        Call<BaseResponse> signUp(@Body UserModel user);

        @POST("login")
        Call<BaseResponse> login(@Body HashMap<String,Object> params);

    }

    public static AccountRepo api(){
        return new AccountRepo();
    }
}
