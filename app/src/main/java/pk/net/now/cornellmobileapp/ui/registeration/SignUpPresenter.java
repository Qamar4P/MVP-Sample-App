package pk.net.now.cornellmobileapp.ui.registeration;

import android.support.annotation.StringRes;

import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.data.AccountRepo;
import pk.net.now.cornellmobileapp.data.DataUpdate;
import pk.net.now.cornellmobileapp.data.model.UserModel;
import pk.net.now.cornellmobileapp.ui.shared.BasePresenter;
import pk.net.now.cornellmobileapp.ui.shared.BaseView;

/**
 * Created by Qamar on 9/5/2017.
 */

public class SignUpPresenter extends BasePresenter<SignUpPresenter.SignUpView> {

    public void signUp(UserModel model){
        AccountRepo.api().signUp(model,update -> {
            if (view == null) {
                return;
            }
            if(update.code == DataUpdate.OK){
                view.success();
            }else {
                view.error(R.string.error_connection);
            }
        });
    }

    public interface SignUpView extends BaseView {
        void success();
        void error(@StringRes int errorRes);
    }
}
