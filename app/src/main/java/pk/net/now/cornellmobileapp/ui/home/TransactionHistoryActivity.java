package pk.net.now.cornellmobileapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;

public class TransactionHistoryActivity extends BaseActivity {

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitleView;
    @BindView(R.id.transactionHistory)
    RecyclerView transactionHistoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        toolbarTitleView.setText(R.string.transaction_history);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TransactionHistoryActivity.class);
        context.startActivity(intent);
    }
}
