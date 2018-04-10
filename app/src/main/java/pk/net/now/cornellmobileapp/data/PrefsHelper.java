package pk.net.now.cornellmobileapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import pk.net.now.cornellmobileapp.App;

/**
 * Created by Qamar on 9/4/2017.
 */

public class PrefsHelper {
    public final SharedPreferences mPrefs;

    public PrefsHelper(App context) {
        mPrefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        mPrefs.edit()
                .putString("token",token)
                .apply();
    }
    public String getToken() {
        return mPrefs.getString("token",AppConst.DEFAULT_ACCESS_TOKEN);
    }

    public void logout() {
        mPrefs.edit().clear().apply();
    }

    public void set(String cacheKey, boolean value) {
        mPrefs.edit().putBoolean(cacheKey,value).apply();
    }

    public void putList(String key, List list) {
        SharedPreferences.Editor edit = mPrefs.edit();
        if(list == null) edit.putString(key,null);
        else edit.putString(key,new Gson().toJson(list));
        edit.apply();
    }

    public <T>  List<T> getList(String key,TypeToken<ArrayList<T>> type) {
        String json = mPrefs.getString(key,null);
        if(json != null && !json.isEmpty()){
            return new Gson().fromJson(json, type.getType());
        }
        return new ArrayList<T>();
    }
}
