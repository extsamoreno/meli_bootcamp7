package com.meli.socialmeli.model;

public class Seller extends UserMeli {
    private UserMeli[] Followers;
    public Seller(int userId, String userName) {
        super(userId, userName);
    }
}
