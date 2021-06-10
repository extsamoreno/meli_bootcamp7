package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // User can be seller and buyer
    private int userId;
    private String userName;

    // Lists with follows/follwers IDs
    ArrayList<User> follows = new ArrayList<>();
    ArrayList<User> followers = new ArrayList<>();


}
