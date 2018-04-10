package pk.net.now.cornellmobileapp.ui.registeration;

import android.support.annotation.StringRes;

import pk.net.now.cornellmobileapp.App;
import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.data.AccountRepo;
import pk.net.now.cornellmobileapp.data.DataUpdate;
import pk.net.now.cornellmobileapp.ui.shared.BasePresenter;
import pk.net.now.cornellmobileapp.ui.shared.BaseView;

/**
 * Created by Qamar on 9/5/2017.
 */

public class LoginPresenter extends BasePresenter<LoginPresenter.LoginView> {

    public void login(String email,String password){
        AccountRepo.api().login(email,password, update -> {
            if (view == null) {
                return;
            }
            if(update.code == DataUpdate.OK){
                String authToken = update.payload.getAsJsonObject("authentication").get("token").getAsString();
                App.prefs().saveToken(authToken);
                view.success();
            }else {
                view.error(R.string.error_connection);
            }
        });
    }

    public interface LoginView extends BaseView {
        void success();
        void error(@StringRes int errorRes);
    }
}
