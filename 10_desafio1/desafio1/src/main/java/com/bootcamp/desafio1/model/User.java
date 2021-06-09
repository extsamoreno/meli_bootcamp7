package com.bootcamp.desafio1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private int userId;
    private String userName;
    private boolean seller;
    private ArrayList<User> followers;
    private ArrayList<User> followed;
    private ArrayList<Integer> posts;

}
