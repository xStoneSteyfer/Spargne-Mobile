package com.example.spargne.entity;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Advisor {

    @SerializedName("id")
    private int id;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("roles")
    private JsonArray roles;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("postalAddress")
    private String postalAddress;
    @SerializedName("registrerDate")
    private Date registrerDate;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("phoneNumber")
    private String phoneNumber;

    public int getId() { return id; }
    public String getUuid() { return uuid; }
    public JsonArray getRoles() { return roles; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getFirstName() { return firstName; }
    public String getPostalAddress() { return postalAddress; }
    public Date getRegistrerDate() { return registrerDate; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getPhoneNumber() { return phoneNumber; }
}
