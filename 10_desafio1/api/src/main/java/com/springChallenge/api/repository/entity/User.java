package com.springChallenge.api.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private ArrayList<User> sellersFollowed;
    private ArrayList<User> followers;
    private ArrayList<Post> posts;

    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
        this.sellersFollowed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addSellerFollowed(User user){
        this.sellersFollowed.add(user);
    }

    public void addFollower(User user) {
        this.followers.add(user);
    }

    public void copyAll(User user){
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.sellersFollowed = user.getSellersFollowed();
        this.followers = user.getFollowers();
        this.posts = user.getPosts();
    }
}
