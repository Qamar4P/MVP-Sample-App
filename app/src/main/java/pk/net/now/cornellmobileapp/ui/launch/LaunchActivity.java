package pk.net.now.cornellmobileapp.ui.launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.ui.registeration.LoginActivity;
import pk.net.now.cornellmobileapp.ui.registeration.LoginPresenter;
import pk.net.now.cornellmobileapp.ui.registeration.SignupActivity;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;

public class LaunchActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    @OnClick({R.id.buttonSignIn,R.id.buttonSignUp})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignIn:
                LoginActivity.start(this);
                break;
            case R.id.buttonSignUp:
                SignupActivity.start(this);
                break;
        }
    }
}
