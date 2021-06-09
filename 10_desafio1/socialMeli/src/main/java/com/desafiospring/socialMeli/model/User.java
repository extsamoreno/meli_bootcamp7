package com.desafiospring.socialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private int userId;
    private List<User> followed;
    private List<User> followedBy;

    public User(int userId, String userName) {}
}
