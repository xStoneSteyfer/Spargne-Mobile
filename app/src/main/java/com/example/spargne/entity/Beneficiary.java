package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Beneficiary {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("added_date")
    private Date added_date;
    @SerializedName("account")
    private Account account;

    public int getId() { return id; }
    public String getName() { return name; }
    public Date getAdded_date() { return added_date; }
    public Account getAccount() { return account; }
}
