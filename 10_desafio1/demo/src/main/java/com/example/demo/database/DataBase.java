package com.example.demo.database;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {
    public static ArrayList<User> dataBaseUsers = new ArrayList<>(Arrays.asList(new User("user1"),
            new User("user2"),
            new User("user3"),
            new User("user4"),
            new User("user5")));


}
