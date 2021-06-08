package com.example.desafio1.repository;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
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
public class UserRepository implements IUserRepository{
    private HashMap<Integer, User> usersDict = setUsersDict(loadDataBase());

    private ArrayList<User> loadDataBase ()
    {
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
    private HashMap<Integer, User> setUsersDict(ArrayList<User> usersList)
    {
        HashMap<Integer, User> r = new HashMap<>();
        for (User user: usersList) {
            r.put(user.getId(), user);
        }
        return r;
    }

    @Override
    public ArrayList<User> getUsersList() {
        return new ArrayList<>(usersDict.values());
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException{
        if(!usersDict.containsKey(userId)){
            throw new UserNotFoundException(userId);
        }
        return usersDict.get(userId);
    }


}
