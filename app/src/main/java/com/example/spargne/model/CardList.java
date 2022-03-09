package com.example.spargne.model;

public class CardList {
    private String owner;
    private String accountId;
    private String status;
    private String expirationDate;
    private String libelle;
    private String cardId;

    public String getOwner() { return owner; }
    public String getAccountId() { return accountId; }
    public String getStatus() { return status; }
    public String getExpirationDate() { return expirationDate; }
    public String getLibelle() { return libelle; }
    public String getCardId() { return cardId; }

    public CardList(String owner, String accountId, String status, String expirationDate, String libelle, String cardId) {
        this.owner = owner;
        this.accountId = accountId;
        this.status = status;
        this.expirationDate = expirationDate;
        this.libelle = libelle;
        this.cardId = cardId;
    }
}
