package pk.net.now.cornellmobileapp.ui.registeration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pk.net.now.cornellmobileapp.ui.home.HomeActivity;
import pk.net.now.cornellmobileapp.ui.registeration.support.LoginPresenter;
import pk.net.now.cornellmobileapp.ui.registeration.support.LoginView;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;
import pk.net.now.cornellmobileapp.R;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    LoginPresenter presenter = new LoginPresenter();
    private EditText editEmail,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.attach(this);
        initUi();
    }

    private void initUi() {
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);
        findViewById(R.id.buttonLogin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:

                break;
        }
    }

    @Override
    public void success() {
        Toast.makeText(this,"Successfully logged in!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(@StringRes int errorRes) {
        Toast.makeText(this,errorRes,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Demo logged in!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
