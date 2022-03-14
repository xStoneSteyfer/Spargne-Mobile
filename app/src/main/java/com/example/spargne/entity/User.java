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
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("postal_address")
    private String postal_address;
    @SerializedName("registrer_date")
    private Date registrer_date;
    @SerializedName("postal_code")
    private String postal_code;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("phone_number")
    private String phone_number;
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
    public String getFirst_name() { return first_name; }
    public String getPostal_address() { return postal_address; }
    public Date getRegistrer_date() { return registrer_date; }
    public String getPostal_code() { return postal_code; }
    public String getCountry() { return country; }
    public String getCity() { return city; }
    public String getPhone_number() { return phone_number; }
    public Advisor getAdvisor() { return advisor; }
    public boolean isFirstMdp() { return firstMdp; }
    public Account[] getAccounts() { return accounts; }
    public Beneficiary[] getBeneficiaries() { return beneficiaries; }
    public Card[] getCards() { return cards; }

    public void setAccounts(Account[] accounts) { this.accounts = accounts; }
    public void setBeneficiaries(Beneficiary[] beneficiaries) { this.beneficiaries = beneficiaries; }
    public void setCards(Card[] cards) { this.cards = cards; }
}
