package pk.net.now.cornellmobileapp.data.model;

import com.google.gson.JsonObject;

/**
 * Created by Qamar on 9/7/2017.
 */

public class BaseResponse {
    public Integer status;
    public String message;
    public Integer errorCode;
    public JsonObject payload;
    public JsonObject modelState;
}
