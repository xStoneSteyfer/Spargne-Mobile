package com.example.spargne.entity;

import com.google.gson.annotations.SerializedName;

public class MeetingTopic {
    @SerializedName("id")
    int id;

    @SerializedName("libelle")
    String libelle;

    public MeetingTopic(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
