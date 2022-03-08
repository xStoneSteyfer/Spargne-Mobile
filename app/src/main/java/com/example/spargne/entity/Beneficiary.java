package com.example.spargne.entity;

import java.util.Date;

public class Beneficiary {
    private int id;
    private String name;
    private Date added_date;
    private Account account;

    public int getId() { return id; }
    public String getName() { return name; }
    public Date getAdded_date() { return added_date; }
    public Account getAccount() { return account; }
}
