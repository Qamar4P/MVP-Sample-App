package pk.net.now.cornellmobileapp.ui.registeration;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import pk.net.now.cornellmobileapp.ui.home.HomeActivity;
import pk.net.now.cornellmobileapp.ui.launch.LaunchActivity;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;
import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.ui.shared.AppUtils;

public class LoginActivity extends BaseActivity implements LoginPresenter.LoginView {

    LoginPresenter presenter = new LoginPresenter();
    //UI vars
    @BindView(R.id.email) EditText emailView;
    @BindView(R.id.password) EditText passwordView;
    private Dialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.attach(this);
    }

    @OnClick(R.id.buttonLogin)
    public void tapLogin(View view) {
        final String email = emailView.getText().toString().trim();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailView.setError("Enter valid email!");
            emailView.requestFocus();
            return;
        }
        final String password = passwordView.getText().toString().trim();
        if (password.isEmpty() || password.length() <4) {
            passwordView.setError("Enter valid password of at least 4 characters!");
            passwordView.requestFocus();
            return;
        }
        AppUtils.changeKeyboardVisibility(getCurrentFocus(),false);

        pd = AppUtils.getProgressDialog(this);
        pd.show();
        presenter.login(email,password);
    }

    @Override
    public void success() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        toast("Successfully logged in!");
        HomeActivity.start(this);
        finish();
    }

    @Override
    public void error(@StringRes int errorRes) {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        toast(getString(errorRes));
        toast("Demo logged in!");
        HomeActivity.start(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
