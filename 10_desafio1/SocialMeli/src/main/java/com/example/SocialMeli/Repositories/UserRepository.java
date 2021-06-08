package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository implements iUserRepository{

    private List<User> users= this.loadDataBase();
    @Override
    public FollowDTO follow(int followerID, int followedID) throws UserNotFoundException {

        User follower = this.findUserByID(followerID);
        User followed = this.findUserByID(followedID);

        followed.addFollower(follower.getId());
        follower.addFollowed(followed.getId());

        return new FollowDTO(followedID,followerID, "Follow");
    }

    @Override
    public FollowCountDTO getFollowersCount(int userId) throws UserNotFoundException {

        User user = this.findUserByID(userId);

        return new FollowCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }

    @Override
    public FollowersDTO getFollowers(int userId) throws UserNotFoundException {
        User user = this.findUserByID(userId);
        List<UserDTO> followerDTOs = this.getUserDTOListByIds(user.getFollowers());

        return new FollowersDTO(user.getId(), user.getName(), followerDTOs);
    }

    @Override
    public FollowedDTO getFollowed(int userId) throws UserNotFoundException {

        User user = this.findUserByID(userId);
        List<UserDTO> followerDTOs = this.getUserDTOListByIds(user.getFollowedBy());

        return new FollowedDTO(user.getId(), user.getName(), followerDTOs);
    }

    private List<UserDTO> getUserDTOListByIds(List<Integer> UserIds) throws UserNotFoundException {

        List<UserDTO> userDTOS = new ArrayList<>();

        for (int i = 0; i < UserIds.size(); i++) {

            User user = this.findUserByID(UserIds.get(i));
            userDTOS.add(UserMapper.toDTO(user));

        }

        return userDTOS;

    }

    private int findUserIndexByID(int userId) throws UserNotFoundException{

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId ){
                return i;
            }
        }
        throw new UserNotFoundException(userId);
    }
    private User findUserByID(int userId) throws UserNotFoundException{

        return users.get(this.findUserIndexByID(userId));
    }
    public List<User> getUsers(){

        return this.users;
    }
    private List<User> loadDataBase(){

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
