package com.meli.spring_challenge.repository.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring_challenge.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private List<User> userList;

    UserRepositoryImpl(){
        this.userList = loadDataBase();
    }

    @Override
    public User getUserByID(int userID) {
        return this.userList.stream()
                .filter(user -> user.getUserID() == userID )
                .findFirst()
                .orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean removeUser(User user) {
        return userList.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userList;
    }

    private List<User> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper om = new ObjectMapper();
        TypeReference<List<User>> typeDef = new TypeReference<>(){};
        List<User> userList = null;
        try{
            userList = om.readValue(file,typeDef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
