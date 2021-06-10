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
    private int id, followed_count, followers_count;
    private List<Integer> followed; //Sellers ID
    private List<Integer> followers; //Users ID
    private List<Integer> publications; //Users ID

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        this.followers_count = this.followed_count = 0;
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.publications = new ArrayList<>();
    }

    public User() {
        this.followers_count = this.followed_count = 0;
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.publications = new ArrayList<>();
    }
}
