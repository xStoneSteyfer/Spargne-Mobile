package com.example.spargne.entity;

public class Account {
    private String libelle;
    private double amount;
    private String id;
    private String owner;

    public String getLibelle() { return libelle; }
    public double getAmount() { return amount; }
    public String getId() { return id; }
    public String getOwner() { return owner; }

    public Account(String libelle, double amount, String id, String owner) {
        this.libelle = libelle;
        this.amount = amount;
        this.id = id;
        this.owner = owner;
    }
}
