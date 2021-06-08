package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class UserMeli {
    private int userId;
    private String userName;
    private ArrayList<UserMeli> followers = new ArrayList<>();
    private ArrayList<UserMeli> followed = new ArrayList<>();

    public UserMeli(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    //private String followed;
    //private String followers;
}
