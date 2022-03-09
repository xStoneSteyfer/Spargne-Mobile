package com.example.spargne.model;

import com.example.spargne.entity.User;

public class Singleton {

    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }





    public static final String BASE_URL = "https://s4-8040.nuage-peda.fr/Spargne/public/api/";
    private String token;
    private User user;





    public String getToken() { return token; }
    public User getUser() { return user; }



    public void setToken(String token) { this.token = token; }
    public void setUser(User user) { this.user = user; }
}
