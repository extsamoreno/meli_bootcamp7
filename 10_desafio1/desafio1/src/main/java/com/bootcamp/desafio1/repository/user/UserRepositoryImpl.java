package com.bootcamp.desafio1.repository.user;

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


    @Override
    public boolean userIdExists(int userId) {
        // Validate that the userId is in the Data Base
        if(usersDB.containsKey(userId))
            return true;
        else
            return false;
    }


    @Override
    public User getUserById(int id) throws UserNotFoundException {

        // Validate that the userId is in the Data Base
        if( userIdExists(id) )
            return  usersDB.get(id);
        else
            throw new UserNotFoundException(id);
    }


    @Override
    public void updateUserInDB(User user) {
        usersDB.replace(user.getUserId(), user);
    }


}
