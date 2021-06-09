package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<User> followers=new ArrayList<>();
    private List<User> followed=new ArrayList<>();
    private List<Post> posts=new ArrayList<>();

    public User(int userId, String userName){
        this.userId=userId;
        this.userName=userName;
    }

    public User(User user){
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.followers=user.getFollowers();
        this.followed=user.getFollowed();
        this.posts=user.getPosts();
    }

    public void addFollower(User user){
        followers.add(user);
    }

    public void addFollowed(User user){
        followed.add(user);
    }
}
