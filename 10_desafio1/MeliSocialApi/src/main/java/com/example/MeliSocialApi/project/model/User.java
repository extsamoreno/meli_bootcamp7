package com.example.MeliSocialApi.project.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
@Getter
public class User {
    private Integer id;
    private String name = "";
    private LinkedHashSet<Integer> followers;
    private LinkedHashSet<Integer> following;
    public User(Integer id){
        this.id = id;
        followers = new LinkedHashSet<Integer>();
        following = new LinkedHashSet<Integer>();
    }
    public User(Integer id,String name){
        this.id = id;
        this.name = name;
        followers = new LinkedHashSet<Integer>();
        following = new LinkedHashSet<Integer>();
    }
    public void addFollower(User user){
        followers.add(user.getId());
    }
    public void addFollower(Integer user){
        followers.add(user);
    }
    public void addFollowing(User user){
        following.add(user.getId());
    }
    public void addFollowing(Integer user){
        following.add(user);
    }
    public void unfollower(Integer user){followers.remove(user);}
    public void unfollower(User user){followers.remove(user.getId());}
    public void unfollowing(Integer user){following.remove(user);}
    public void unfollowing(User user){following.remove(user.getId());}

}
