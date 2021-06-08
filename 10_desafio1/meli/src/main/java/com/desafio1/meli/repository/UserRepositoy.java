package com.desafio1.meli.repository;

import com.desafio1.meli.model.User;
import com.desafio1.meli.service.DTO.RequestFollowUserToUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;


@Repository
public class UserRepositoy implements IUserrepository {

    private List<User> users ;

    public UserRepositoy() {
        this.users = loadDatabase();
    }

    @Override
    public boolean follow(RequestFollowUserToUser requestFollowUserToUser){
        try{
            User user = findUserById(requestFollowUserToUser.getUser().getId());
            User user_followed = findUserById(requestFollowUserToUser.getUserFollower().getId());
            user.getFollow().add(user_followed);
            user_followed.getFollower().add(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }



    @Override
    public User findUserById(Integer id){
        User user = null;
        for (User loadUser : this.users) {
            if (loadUser.getId().equals(id)){
                user = loadUser;
            }
        }
        return user;
    }

    private List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
