package com.example.spargne.model;

import com.example.spargne.entity.Login;
import com.example.spargne.entity.MeetingTopic;
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





    public static final String BASE_URL = "https://epsi.nuage-pedagogique.fr/G1-situation1/api/";
    public String currentFragment = "homeFragment";

    private boolean requestGetUserByUuid;
    private boolean requestGetAccountByUuid;
    private boolean requestGetTransactionById;
    private MeetingTopic[] meetingTopics;
    private MeetingTopic meetingTopicsSelected;

    private Login login;
    private String token;
    private User user;



    public boolean isRequestGetUserByUuid() { return requestGetUserByUuid; }
    public boolean isRequestGetAccountByUuid() { return requestGetAccountByUuid; }
    public boolean isRequestGetTransactionById() { return requestGetTransactionById; }

    public Login getLogin() { return login; }
    public String getToken() { return token; }
    public User getUser() { return user; }



    public void setRequestGetUserByUuid(boolean requestGetUserByUuid) { this.requestGetUserByUuid = requestGetUserByUuid; }
    public void setRequestGetAccountByUuid(boolean requestGetAccountByUuid) { this.requestGetAccountByUuid = requestGetAccountByUuid; }
    public void setRequestGetTransactionById(boolean requestGetTransactionById) { this.requestGetTransactionById = requestGetTransactionById; }

    public void setLogin(Login login) { this.login = login; }
    public void setToken(String token) { this.token = token; }
    public void setUser(User user) { this.user = user; }

    public MeetingTopic[] getMeetingTopics() {
        return meetingTopics;
    }

    public void setMeetingTopics(MeetingTopic[] meetingTopics) {
        this.meetingTopics = meetingTopics;
    }

    public MeetingTopic getMeetingTopicsSelected() {
        return meetingTopicsSelected;
    }

    public void setMeetingTopicsSelected(MeetingTopic meetingTopicsSelected) {
        this.meetingTopicsSelected = meetingTopicsSelected;
    }

    public void clear() {
        currentFragment = "homeFragment";

        requestGetUserByUuid = false;
        requestGetAccountByUuid = false;
        requestGetTransactionById = false;

        login = null;
        token = null;
        user = null;
    }
}
