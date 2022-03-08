package com.example.spargne.entity;

import java.util.Date;

public class Account {
    private String libelle;
    private double amount;
    private String id;
    private String owner;

    public String getLibelle() { return libelle; }
    public double getAmount() { return amount; }
    public String getOwner() { return owner; }

    public Account(String libelle, double amount, String id, String owner) {
        this.libelle = libelle;
        this.amount = amount;
        this.id = id;
        this.owner = owner;
    }

    /*private int id;
    private String name;
    private String num;
    private String iban;
    private int balance;
    private Date creation_date;
    private int limitBalance;
    private int overdraft;
    private int rate;*/

    public String getId() { return id; }
    /*public String getName() { return name; }
    public String getNum() { return num; }
    public String getIban() { return iban; }
    public int getBalance() { return balance; }
    public Date getCreation_date() { return creation_date; }
    public int getLimitBalance() { return limitBalance; }
    public int getOverdraft() { return overdraft; }
    public int getRate() { return rate; }*/
}
