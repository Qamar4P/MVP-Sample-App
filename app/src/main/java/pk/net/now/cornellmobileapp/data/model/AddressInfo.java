package pk.net.now.cornellmobileapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressInfo {

@SerializedName("AddressL1")
@Expose
public String addressL1;
@SerializedName("Country")
@Expose
public String country;
@SerializedName("City")
@Expose
public String city;
@SerializedName("PostCode")
@Expose
public String postCode;
@SerializedName("AddressL2")
@Expose
public String addressL2;
@SerializedName("County")
@Expose
public String county;

}