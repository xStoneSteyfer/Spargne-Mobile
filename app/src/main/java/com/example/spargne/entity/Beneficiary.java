package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Beneficiary {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("addedDate")
    private Date addedDate;
    @SerializedName("account")
    private Account account;

    public int getId() { return id; }
    public String getName() { return name; }
    public Date getAddedDate() { return addedDate; }
    public Account getAccount() { return account; }
}
