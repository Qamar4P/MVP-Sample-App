package pk.net.now.cornellmobileapp.ui.registeration.support;

import android.support.annotation.StringRes;

import pk.net.now.cornellmobileapp.ui.shared.BaseView;

/**
 * Created by Qamar on 9/4/2017.
 */

public interface SignUpView extends BaseView {
    void success();
    void error(@StringRes int errorRes);
}
