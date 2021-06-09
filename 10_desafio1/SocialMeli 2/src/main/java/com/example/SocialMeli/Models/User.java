package com.example.SocialMeli.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User{

    private int id;
    private String name;
    private List<Integer> followers;
    private List<Integer> following;
    private List<Integer> posts;
    private List<Integer> promPosts;

}
