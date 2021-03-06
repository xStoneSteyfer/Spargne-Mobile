package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Account {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("num")
    private String num;
    @SerializedName("iban")
    private String iban;
    @SerializedName("balance")
    private double balance;
    @SerializedName("creation_date")
    private String creation_date;
    @SerializedName("limitBalance")
    private int limitBalance;
    @SerializedName("overdraft")
    private int overdraft;
    @SerializedName("rate")
    private int rate;
    @SerializedName("type")
    private AccountType type;
    private int index;
    private Transaction[] transactions;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getNum() { return num; }
    public String getIban() { return iban; }
    public double getBalance() { return balance; }
    public String getCreation_date() { return creation_date; }
    public int getLimitBalance() { return limitBalance; }
    public int getOverdraft() { return overdraft; }
    public int getRate() { return rate; }
    public AccountType getType() { return type; }
    public int getIndex() { return index; }
    public Transaction[] getTransactions() { return transactions; }

    public void setIndex(int index) { this.index = index; }
    public void setTransactions(Transaction[] transactions) { this.transactions = transactions; }
}
