package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class User{

    private String userName;
    Map<Integer,User> followed;
    Map<Integer, User> followers;
}
