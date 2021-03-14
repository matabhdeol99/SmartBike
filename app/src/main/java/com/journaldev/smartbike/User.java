package com.journaldev.smartbike;

public class User {
    public String id;
    public String userName;
    public String phone;
    public String email;
    public String password;

    public User(String id, String userName, String phone, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

}