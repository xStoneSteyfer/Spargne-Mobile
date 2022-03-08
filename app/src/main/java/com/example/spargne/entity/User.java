package com.example.spargne.entity;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
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
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("postal_address")
    private String postal_address;
    @SerializedName("registrer_date")
    private Date registrer_date;
    @SerializedName("postal_code")
    private String postal_code;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("phone_number")
    private String phone_number;
    @SerializedName("advisor")
    private String advisor;
    @SerializedName("customers")
    private JsonArray customers;
    @SerializedName("firstMdp")
    private boolean firstMdp;

    @SerializedName("accounts")
    private Account accounts;
    @SerializedName("beneficiaries")
    private Beneficiary beneficiaries;
}
