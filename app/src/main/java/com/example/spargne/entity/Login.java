package com.example.spargne.entity;

public class Login {
    private String uuid;
    private String password;

    public Login(String uuid, String password) {
        this.uuid = uuid;
        this.password = password;
    }

    public String getUuid() { return uuid; }

    public void setPassword(String password) { this.password = password; }
}
