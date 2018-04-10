package pk.net.now.cornellmobileapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import pk.net.now.cornellmobileapp.ui.registeration.LoginActivity;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;
import pk.net.now.cornellmobileapp.R;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitleView;
    @BindView(R.id.pin)
    EditText pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @OnClick(R.id.buttonNext)
    public void tapNext(View view) {
        if (pinView.getText().length() == 4) {
            TransactionHistoryActivity.startActivity(this);
        }else {
            pinView.setError("Enter valid pin!");
        }
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
