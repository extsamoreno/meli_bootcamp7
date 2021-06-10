package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMeli {

    private int userId;
    private String userName;
    private ArrayList<Integer> followers = new ArrayList<>();
    private ArrayList<Integer> followedBy = new ArrayList<>();

    private List<Post> posts = new ArrayList<>();

    private boolean merchant = false;

    public UserMeli(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserMeli(int userId, String userName, Post post) {
        this.userId = userId;
        this.userName = userName;
        this.posts.add(post);
    }
}
