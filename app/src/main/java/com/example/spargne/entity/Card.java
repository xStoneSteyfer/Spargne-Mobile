package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Card {

    @SerializedName("id")
    private int id;
    @SerializedName("number")
    private String number;
    @SerializedName("crypto")
    private String crypto;
    @SerializedName("creationDate")
    private Date creationDate;
    @SerializedName("type")
    private CardType type;
}
