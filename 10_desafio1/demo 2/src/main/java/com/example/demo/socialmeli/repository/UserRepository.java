package com.example.demo.socialmeli.repository;

import com.example.demo.socialmeli.service.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository implements IUserRepository{
    @Override
    public User getUserById(int id) {
        List<User> userList = null;
        userList = loadDatabase();
        User result = null;
        if (userList!=null){
            Optional<User> item = userList.stream().filter(user -> user.getUserId()==id).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
        }
        return result;
    }
    private List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/users.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<>() {};
        List<User> users = null;
        try {
            users =  objectMapper.readValue(file,typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public void refreshUser(User user) {
        List<User> users = this.loadDatabase();
        for (int i=0; i<users.size();i++) {
            User userDb = users.get(i);
            if (userDb.getUserId() == user.getUserId()){
                users.set(i,user);
            }

        }
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/users.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file,users);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.loadDatabase();
    }
}
