package pk.net.now.cornellmobileapp.ui.registeration;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import pk.net.now.cornellmobileapp.ui.registeration.support.SignUpPresenter;
import pk.net.now.cornellmobileapp.ui.registeration.support.SignUpView;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;
import pk.net.now.cornellmobileapp.R;

public class SignupActivity extends BaseActivity implements SignUpView, View.OnClickListener {

    //Interactor
    SignUpPresenter presenter = new SignUpPresenter();
    //UI vars
    private EditText editEmail,editPassword;
    private Spinner spinnerTitle;
    private Spinner homeCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        presenter.attach(this);
        initUi();
    }

    private void initUi() {
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);
        spinnerTitle = (Spinner) findViewById(R.id.title);
        spinnerTitle.setPadding(0,0,0,0);
        spinnerTitle.setSelection(0);
        homeCountry = (Spinner) findViewById(R.id.homeCountry);
        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        String country;
        for( Locale loc : locale ){
            country = loc.getDisplayCountry();
            if( country.length() > 0 && !countries.contains(country) ){
                countries.add( country );
            }
        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, countries);
        homeCountry.setAdapter(adapter);
        homeCountry.setPadding(0,0,0,0);
        findViewById(R.id.buttonRegister).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRegister:
                presenter.signUp();
                break;
        }
    }

    @Override
    public void success() {
        Toast.makeText(this,"Successfully registered!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(@StringRes int errorRes) {
        Toast.makeText(this,errorRes,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
