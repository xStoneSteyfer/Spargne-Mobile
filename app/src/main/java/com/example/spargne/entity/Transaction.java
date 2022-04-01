package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

public class Transaction {
    @SerializedName("id")
    private int id;
    @SerializedName("date")
    private String date;
    @SerializedName("fromAccount")
    private int fromAccount;
    @SerializedName("destinationAccount")
    private int destinationAccount;
    @SerializedName("fromName")
    private String fromName;
    @SerializedName("destinationName")
    private String destinationName;
    @SerializedName("fromFirstName")
    private String fromFirstName;
    @SerializedName("destinationFirstName")
    private String destinationFirstName;
    @SerializedName("amount")
    private double amount;
    @SerializedName("type")
    private String type;

    public int getId() { return id; }
    public String getDate() { return date; }
    public int getFromAccount() { return fromAccount; }
    public int getDestinationAccount() { return destinationAccount; }
    public String getFromName() { return fromName; }
    public String getDestinationName() { return destinationName; }
    public String getFromFirstName() { return fromFirstName; }
    public String getDestinationFirstName() { return destinationFirstName; }
    public double getAmount() { return amount; }
    public String getType() { return type; }

    public void setAmount(double amount) { this.amount = amount; }
}
