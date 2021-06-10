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
}
