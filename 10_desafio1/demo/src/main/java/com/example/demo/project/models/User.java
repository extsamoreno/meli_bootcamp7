package com.example.demo.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
public class User {
    private String name;
    private int id, following_count, followers_count;
    private List<Integer> following; //Sellers ID
    private List<Integer> followers; //Users ID

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.followers_count = this.following_count = 0;
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public User() {
        this.followers_count = this.following_count = 0;
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollowing(int sellerID) {
        if (!following.contains(sellerID)) {
            following.add(sellerID);
            following_count++;
        }
    }

    public void removeFollowing(int sellerID) {
        if (following.contains(sellerID)) {
            following.remove(sellerID);
            followers_count--;
        }
    }

    public void addFollower(int sellerID) {
        if (!following.contains(sellerID)) {
            following.add(sellerID);
            followers_count++;
        }
    }

    public void removeFollower(int sellerID) {
        if (followers.contains(sellerID)) {
            followers.remove(sellerID);
            followers_count--;
        }
    }
}
