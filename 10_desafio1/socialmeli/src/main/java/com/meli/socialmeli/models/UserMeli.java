package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMeli {

    private int userId;
    private String userName;
    private ArrayList<Integer> followers = new ArrayList<>();
    private ArrayList<Integer> followedBy = new ArrayList<>();

    public UserMeli(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
