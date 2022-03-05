package com.example.spargne.entity;

import android.graphics.Bitmap;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.Date;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("roles")
    private JsonArray roles;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("postal_address")
    private String postal_address;
    @SerializedName("registrer_date")
    private Date registrer_date;
    @SerializedName("profil_picture")
    private Bitmap profil_picture;
    @SerializedName("postal_code")
    private String postal_code;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("phone_number")
    private String phone_number;


    public int getId() { return id; }
    public String getUuid() { return uuid; }
    public JsonArray getRoles() { return roles; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getFirst_name() { return first_name; }
    public String getPostal_address() { return postal_address; }
    public Date getRegistrer_date() { return registrer_date; }
    public Bitmap getProfil_picture() { return profil_picture; }
    public String getPostal_code() { return postal_code; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getPhone_number() { return phone_number; }
}
