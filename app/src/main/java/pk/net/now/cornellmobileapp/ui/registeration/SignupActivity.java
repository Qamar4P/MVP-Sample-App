package pk.net.now.cornellmobileapp.ui.registeration;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import pk.net.now.cornellmobileapp.data.model.AddressInfo;
import pk.net.now.cornellmobileapp.data.model.UserModel;
import pk.net.now.cornellmobileapp.ui.shared.BaseActivity;
import pk.net.now.cornellmobileapp.R;
import pk.net.now.cornellmobileapp.ui.shared.AppUtils;

public class SignupActivity extends BaseActivity implements SignUpPresenter.SignUpView {

    //MVP
    SignUpPresenter presenter = new SignUpPresenter();
    //UI vars
    @BindView(R.id.email) EditText emailView;
    @BindView(R.id.password) EditText passwordView;
    @BindView(R.id.title) Spinner titleView;
    @BindView(R.id.firstName) EditText firstNameView;
    @BindView(R.id.secondName) EditText secondNameView;
    @BindView(R.id.dateOfBirth) EditText dateOfBirthView;
    @BindView(R.id.contactNumber) EditText contactNumberView;
    @BindView(R.id.mobileNumber) EditText mobileNumberView;
    @BindView(R.id.subscribToNewsLetter) CheckBox subscribToNewsLetterView;

    @BindView(R.id.homeCountry) Spinner homeCountryView;
    @BindView(R.id.homeCity) EditText homeCityView;
    @BindView(R.id.homePostCode) EditText homePostCodeView;
    @BindView(R.id.homeAddressLine1) EditText homeAddressLine1View;
    @BindView(R.id.homeAddressLine2) EditText homeAddressLine2View;

    @BindView(R.id.shippingCountry) Spinner shippingCountryView;
    @BindView(R.id.shippingCity) EditText shippingCityView;
    @BindView(R.id.shippingPostCode) EditText shippingPostCodeView;
    @BindView(R.id.shippingAddressLine1) EditText shippingAddressLine1View;
    @BindView(R.id.shippingAddressLine2) EditText shippingAddressLine2View;

    @BindView(R.id.billingCountry) Spinner billingCountryView;
    @BindView(R.id.billingCity) EditText billingCityView;
    @BindView(R.id.billingPostCode) EditText billingPostCodeView;
    @BindView(R.id.billingAddressLine1) EditText billingAddressLine1View;
    @BindView(R.id.billingAddressLine2) EditText billingAddressLine2View;
    private Dialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        presenter.attach(this);
        init();
    }

    private void init() {
        titleView.setPadding(0,0,0,0);
        titleView.setSelection(0);

        //load countries list
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
        countries.add(0,"Select Country");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, countries);

        homeCountryView.setAdapter(adapter);
        homeCountryView.setPadding(0,0,0,0);
        shippingCountryView.setAdapter(adapter);
        shippingCountryView.setPadding(0,0,0,0);
        billingCountryView.setAdapter(adapter);
        billingCountryView.setPadding(0,0,0,0);
    }

    @OnClick(R.id.buttonRegister)
    public void tapRegister(View view) {
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
        final String title = titleView.getSelectedItem().toString().trim();

        final String firstName = firstNameView.getText().toString().trim();
        if (firstName.isEmpty()) {
            firstNameView.setError("Enter valid firstName!");
            firstNameView.requestFocus();
            return;
        }
        final String secondName = secondNameView.getText().toString().trim();
        if (secondName.isEmpty()) {
            secondNameView.setError("Enter valid secondName!");
            secondNameView.requestFocus();
            return;
        }
        final String dateOfBirth = dateOfBirthView.getText().toString().trim();
        if (dateOfBirth.isEmpty()) {
            dateOfBirthView.setError("Enter valid dateOfBirth!");
            dateOfBirthView.requestFocus();
            return;
        }
        final String contactNumber = contactNumberView.getText().toString().trim();
        if (contactNumber.isEmpty()) {
            contactNumberView.setError("Enter valid contactNumber!");
            contactNumberView.requestFocus();
            return;
        }
        final String mobileNumber = mobileNumberView.getText().toString().trim();
        if (mobileNumber.isEmpty()) {
            mobileNumberView.setError("Enter valid mobileNumber!");
            mobileNumberView.requestFocus();
            return;
        }
        final boolean subscribToNewsLetter = subscribToNewsLetterView.isChecked();

        final String homeCountry = homeCountryView.getSelectedItem().toString();
//                if (homeCountry.contains("Select")) {
//                    toast("Enter valid homeCountry!");
//                    return;
//                }
        final String homeCity = homeCityView.getText().toString().trim();
        if (homeCity.isEmpty()) {
            homeCityView.setError("Enter valid homeCity!");
            homeCityView.requestFocus();
            return;
        }
        final String homePostCode = homePostCodeView.getText().toString().trim();
        if (homePostCode.isEmpty()) {
            homePostCodeView.setError("Enter valid homePostCode!");
            homePostCodeView.requestFocus();
            return;
        }
        final String homeAddressLine1 = homeAddressLine1View.getText().toString().trim();
        if (homePostCode.isEmpty()) {
            homePostCodeView.setError("Enter valid homePostCode!");
            homePostCodeView.requestFocus();
            return;
        }
        final String homeAddressLine2 = homeAddressLine2View.getText().toString().trim();

        final String shippingCountry = shippingCountryView.getSelectedItem().toString();
//                if (shippingCountry.contains("Select")) {
//                    toast("Enter valid shippingCountry!");
//                    return;
//                }
        final String shippingCity = shippingCityView.getText().toString().trim();
        if (shippingCity.isEmpty()) {
            shippingCityView.setError("Enter valid shippingCity!");
            shippingCityView.requestFocus();
            return;
        }
        final String shippingPostCode = shippingPostCodeView.getText().toString().trim();
        if (shippingPostCode.isEmpty()) {
            shippingPostCodeView.setError("Enter valid shippingPostCode!");
            shippingPostCodeView.requestFocus();
            return;
        }
        final String shippingAddressLine1 = shippingAddressLine1View.getText().toString().trim();
        if (shippingPostCode.isEmpty()) {
            shippingPostCodeView.setError("Enter valid shippingPostCode!");
            shippingPostCodeView.requestFocus();
            return;
        }
        final String shippingAddressLine2 = shippingAddressLine2View.getText().toString().trim();

        final String billingCountry = billingCountryView.getSelectedItem().toString();
//                if (billingCountry.contains("Select")) {
//                    toast("Enter valid billingCountry!");
//                    return;
//                }
        final String billingCity = billingCityView.getText().toString().trim();
        if (billingCity.isEmpty()) {
            billingCityView.setError("Enter valid billingCity!");
            billingCityView.requestFocus();
            return;
        }
        final String billingPostCode = billingPostCodeView.getText().toString().trim();
        if (billingPostCode.isEmpty()) {
            billingPostCodeView.setError("Enter valid billingPostCode!");
            billingPostCodeView.requestFocus();
            return;
        }
        final String billingAddressLine1 = billingAddressLine1View.getText().toString().trim();
        if (billingPostCode.isEmpty()) {
            billingPostCodeView.setError("Enter valid billingPostCode!");
            billingPostCodeView.requestFocus();
            return;
        }
        final String billingAddressLine2 = billingAddressLine2View.getText().toString().trim();

        //validation

        UserModel userModel = new UserModel();
        userModel.email = email;
        userModel.password = password;
        userModel.title = title;
        userModel.firstName = firstName;
        userModel.lastName = secondName;
        userModel.dateOfBirth = dateOfBirth;
        userModel.contactNo = contactNumber;
        userModel.mobileNo = mobileNumber;
        AddressInfo homeAddress = new AddressInfo();
        homeAddress.country = homeCountry;
        homeAddress.city = homeCity;
        homeAddress.postCode = homePostCode;
        homeAddress.addressL1 = homeAddressLine1;
        homeAddress.addressL2 = homeAddressLine2;
        userModel.homeAddress = homeAddress;

        AddressInfo shippingAddress = new AddressInfo();
        shippingAddress.country = shippingCountry;
        shippingAddress.city = shippingCity;
        shippingAddress.postCode = shippingPostCode;
        shippingAddress.addressL1 = shippingAddressLine1;
        shippingAddress.addressL2 = shippingAddressLine2;
        userModel.shippingAddress = shippingAddress;

        AddressInfo billingAddress = new AddressInfo();
        billingAddress.country = billingCountry;
        billingAddress.city = billingCity;
        billingAddress.postCode = billingPostCode;
        billingAddress.addressL1 = billingAddressLine1;
        billingAddress.addressL2 = billingAddressLine2;
        userModel.billingAddress = billingAddress;

        AppUtils.changeKeyboardVisibility(getCurrentFocus(),false);

        pd = AppUtils.getProgressDialog(this);
        pd.show();

        presenter.signUp(userModel);
    }


    @Override
    public void success() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        toast("Successfully registered, Login now!");
        finish();
    }

    @Override
    public void error(@StringRes int errorRes) {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        toast(getString(errorRes));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SignupActivity.class));
    }

}
