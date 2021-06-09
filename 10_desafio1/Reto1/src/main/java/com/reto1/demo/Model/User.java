package com.reto1.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IUser {
    int id;
    String name;
    ArrayList<IUser> followers = new ArrayList<>();
    ArrayList<IUser> followed = new ArrayList<>();
    ArrayList<Post> posts = new ArrayList<>();

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public void follow(IUser iuser) {
        followers.add(iuser);
    }

    @Override
    public void followed(IUser follower) {
        followed.add(follower);
    }

    public void addPost(Post post){
        posts.add(post);
    }
}
