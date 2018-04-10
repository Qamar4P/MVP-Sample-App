package pk.net.now.cornellmobileapp.ui.shared;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    //    BasePresenter presenter
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if(this instanceof BaseView){
//            presenter.attach((BaseView) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (presenter != null) {
//            presenter.detach();
//        }
//        presenter = null;
    }

    public void toast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
