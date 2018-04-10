package pk.net.now.cornellmobileapp.data;

import java.io.IOException;

import pk.net.now.cornellmobileapp.data.model.BaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Qamar on 9/7/2017.
 */

class BaseRepo {

    void enqueueCall(Call<BaseResponse> call, DataCallBack callBack) {
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                DataUpdate update;
                BaseResponse body = response.body();
                if(response.isSuccessful() && body != null){
                    if(body.status != null && body.status == 200){
                        update = new DataUpdate(DataUpdate.OK, ""+body.message, body.payload);
                    }else {
                        update = new DataUpdate(DataUpdate.ERROR_SERVER, ""+body.message, null);
                    }
                }else {
                    update = new DataUpdate(DataUpdate.ERROR_SERVER, "Server Error!", null);
                }
                callBack.update(update);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                DataUpdate update;
                if(t instanceof IOException){
                    update = new DataUpdate(DataUpdate.ERROR_SERVER, "Check network and try again!", null);
                    callBack.update(update);
                }else {
                    update = new DataUpdate(DataUpdate.ERROR_SERVER, "Server Error!", null);
                }
                callBack.update(update);
            }
        });
    }
}
