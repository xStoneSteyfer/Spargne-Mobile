package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

public class AccountType {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() { return id; }
    public String getName() { return name; }
}
