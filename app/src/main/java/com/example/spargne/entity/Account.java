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

    public void setLibelle(String libelle) { this.libelle = libelle; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setId(String id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }

    public Account(String libelle, double amount, String id, String owner) {
        this.libelle = libelle;
        this.amount = amount;
        this.id = id;
        this.owner = owner;
    }
}
