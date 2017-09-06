package pk.net.now.cornellmobileapp.ui.launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.ui.registeration.LoginActivity;
import pk.net.now.cornellmobileapp.ui.registeration.SignupActivity;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;

public class LaunchActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

         findViewById (R.id.buttonSignIn).setOnClickListener(this);
         findViewById (R.id.buttonSignUp).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignIn:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.buttonSignUp:
                startActivity(new Intent(this, SignupActivity.class));
                break;
        }
    }
}
