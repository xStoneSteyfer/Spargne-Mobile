package com.example.spargne.entity;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("roles")
    private JsonArray roles;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("postalAddress")
    private String postalAddress;
    @SerializedName("registrerDate")
    private String registrerDate;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("advisor")
    private Advisor advisor;
    @SerializedName("firstMdp")
    private boolean firstMdp;
    @SerializedName("accounts")
    private Account[] accounts;
    @SerializedName("beneficiaries")
    private Beneficiary[] beneficiaries;
    @SerializedName("cards")
    private Card[] cards;



    public int getId() { return id; }
    public String getUuid() { return uuid; }
    public JsonArray getRoles() { return roles; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getFirstName() { return firstName; }
    public String getPostalAddress() { return postalAddress; }
    public String getRegistrerDate() { return registrerDate; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getPhoneNumber() { return phoneNumber; }
    public Advisor getAdvisor() { return advisor; }
    public boolean isFirstMdp() { return firstMdp; }
    public Account[] getAccounts() { return accounts; }
    public Beneficiary[] getBeneficiaries() { return beneficiaries; }
    public Card[] getCards() { return cards; }

    public void setAccounts(Account[] accounts) { this.accounts = accounts; }
    public void setBeneficiaries(Beneficiary[] beneficiaries) { this.beneficiaries = beneficiaries; }
    public void setCards(Card[] cards) { this.cards = cards; }
}
