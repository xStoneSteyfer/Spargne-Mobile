package com.example.spargne.entity;

import java.util.Date;

public class Transaction {
    private String date;
    private String libelle;
    private double amount;

    public String getDate() { return date; }
    public String getLibelle() { return libelle; }
    public double getAmount() { return amount; }

    public Transaction(String date, String libelle, double amount) {
        this.date = date;
        this.libelle = libelle;
        this.amount = amount;
    }
}
