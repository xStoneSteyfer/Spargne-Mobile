package com.example.spargne.model;

import androidx.fragment.app.Fragment;

import com.example.spargne.entity.Login;
import com.example.spargne.entity.User;
import com.example.spargne.fragment.HomeFragment;

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
    public String currentFragment = "homeFragment";

    private boolean requestGetUserByUuid;
    private boolean requestGetAccountByUuid;

    private Login login;
    private String token;
    private User user;





    public boolean isRequestGetUserByUuid() { return requestGetUserByUuid; }
    public boolean isRequestGetAccountByUuid() { return requestGetAccountByUuid; }

    public Login getLogin() { return login; }
    public String getToken() { return token; }
    public User getUser() { return user; }



    public void setRequestGetUserByUuid(boolean requestGetUserByUuid) { this.requestGetUserByUuid = requestGetUserByUuid; }
    public void setRequestGetAccountByUuid(boolean requestGetAccountByUuid) { this.requestGetAccountByUuid = requestGetAccountByUuid; }

    public void setLogin(Login login) { this.login = login; }
    public void setToken(String token) { this.token = token; }
    public void setUser(User user) { this.user = user; }

    public void clear() {
        currentFragment = "homeFragment";

        requestGetUserByUuid = false;
        requestGetAccountByUuid = false;

        login = null;
        token = null;
        user = null;
    }
}
