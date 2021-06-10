package com.example.desafiospring.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * USER
     */
    private String username;
    private ArrayList<Seller> following;

    public Post[] getPost() {
    }

    public User[] getFollowed() {
        return following;
    }

    public void setFollowed(User[] followed) {
        this.following = followed;
    }
}

