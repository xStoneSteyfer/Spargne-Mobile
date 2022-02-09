package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

public class EtatRetrofit {
    @SerializedName("etat")
    private String etat;

    @SerializedName("exception")
    private String exception;

    public String getEtat() {
        return etat;
    }
    public String getException() {
        return exception;
    }
}
