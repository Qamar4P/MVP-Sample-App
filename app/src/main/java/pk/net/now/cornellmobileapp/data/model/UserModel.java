package pk.net.now.cornellmobileapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Qamar on 9/7/2017.
 */

public class UserModel {
    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("Password")
    @Expose
    public String password;
    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("FirstName")
    @Expose
    public String firstName;
    @SerializedName("LastName")
    @Expose
    public String lastName;
    @SerializedName("DateOfBirth")
    @Expose
    public String dateOfBirth;
    @SerializedName("ContactNo")
    @Expose
    public String contactNo;
    @SerializedName("MobileNo")
    @Expose
    public String mobileNo;
    @SerializedName("IsSubscribedToNewsletter")
    @Expose
    public Boolean isSubscribedToNewsletter;
    @SerializedName("HomeAddress")
    @Expose
    public AddressInfo homeAddress;
    @SerializedName("ShippingAddress")
    @Expose
    public AddressInfo shippingAddress;
    @SerializedName("BillingAddress")
    @Expose
    public AddressInfo billingAddress;
}
