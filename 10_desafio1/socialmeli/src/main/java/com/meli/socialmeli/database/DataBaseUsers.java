package com.meli.socialmeli.database;

import com.meli.socialmeli.model.dao.model.User;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseUsers {
    public static ArrayList<User> dataBaseUsers = new ArrayList<User>(
            Arrays.asList(new User("Vendedor1", true),
                    new User("Vendedor2", true),
                    new User("Vendedor3", true),
                    new User("Vendedor4", true),
                    new User("Vendedor5", true),
                    new User("Comprador1", false),
                    new User("Comprador2", false),
                    new User("Comprador3", false),
                    new User("Comprador4", false),
                    new User("Comprador5", false)));
}