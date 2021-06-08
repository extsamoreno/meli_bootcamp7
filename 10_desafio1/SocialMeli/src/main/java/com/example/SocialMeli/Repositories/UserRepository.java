package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.FollowDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository implements iUserRepository{

    private List<User> users= this.loadDataBase();
    @Override
    public FollowDTO follow(String followerID, String followedID) throws UserNotFoundException {

        User follower = this.findUserByID(followerID);
        User followed = this.findUserByID(followedID);

        followed.addFollower(follower.getId());
        follower.addFollowed(followed.getId());

        return new FollowDTO(followedID,followerID, "Follow");
    }

    private int findUserIndexByID(String userId) throws UserNotFoundException{

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)){
                return i;
            }
        }
        throw new UserNotFoundException(userId);
    }
    private User findUserByID(String userId) throws UserNotFoundException{

        return users.get(this.findUserIndexByID(userId));
    }
    public List<User> getUsers(){

        return this.users;
    }
    public List<User> loadDataBase(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try{
            users = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }
}
