package com.example.spargne.entity;

public class Singleton {

    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }





    private String baseUrl = "https://s4-8006.nuage-peda.fr/Cosi_S/public/api/";



    public String getBaseUrl() {
        return baseUrl;
    }
}
