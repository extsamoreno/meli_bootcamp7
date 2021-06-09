package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<Post> posts = new ArrayList<>();
    private List<User> followed = new ArrayList<>();

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
