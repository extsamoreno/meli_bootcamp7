package com.SocialMeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int userId;
    private String userName;

    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followed = new ArrayList<>();

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

}
