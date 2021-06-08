package com.bootcamp.desafio1.repository;

import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class UserRepositoryImpl implements IUserRepository{

    // Users Data Base
    private HashMap<Integer, User> usersDB = loadDateBase();


    public HashMap<Integer, User> loadDateBase(){
        HashMap<Integer, User> usersDB = new HashMap<>();
        ArrayList<User> usersList = readDateBase();
        for(User x :  usersList){
            usersDB.put(x.getUserId(), x);
        }
        return usersDB;
    }

    // Method to Read the data from JSON to List of Users called usersList
    public ArrayList<User> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<ArrayList<User>> typeDef = new TypeReference<>() {
        };
        ArrayList<User> usersList = null;
        try {
            usersList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }


    /*
    private List<User> readDateBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<User>> typeDef = new TypeReference<>() {
        };
        List<User> usersList = null;
        try {
            usersList = om.readValue(file, typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

     */

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        User user = null;
        try {
            user = usersDB.get(id);
        } catch (Exception e) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    @Override
    public void updateUserInDB(User user) {
        usersDB.replace(user.getUserId(), user);
    }


}
