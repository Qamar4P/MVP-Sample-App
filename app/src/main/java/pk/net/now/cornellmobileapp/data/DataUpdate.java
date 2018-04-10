package pk.net.now.cornellmobileapp.data;

import com.google.gson.JsonObject;

import okhttp3.Call;
import pk.net.now.cornellmobileapp.data.model.BaseResponse;

/**
 * Created by Qamar on 7/26/2016.
 */
public class DataUpdate {
    public static final int OK = 0;
    public static final int ERROR_DATA = 1;
    public static final int ERROR_SERVER = 2;
    public static final int ERROR_NETWORK = 3;

    public final int code;
    public final String message;
    public final JsonObject payload;

    public DataUpdate(int type, String message, JsonObject payload) {
        this.code = type;
        this.message = message;
        this.payload = payload;
    }
}