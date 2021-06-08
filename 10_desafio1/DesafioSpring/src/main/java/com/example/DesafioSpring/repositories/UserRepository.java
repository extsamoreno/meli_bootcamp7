package com.example.DesafioSpring.repositories;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.services.mapper.UserMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> users= this.loadDataBase();
    @Override
    public FollowDTO followSeller(String userId, String userIdToFollow) throws UserNotFoundException {

        User follower = this.findUserByID(userId);
        User followed = this.findUserByID(userIdToFollow);

        followed.addFollower(follower.getId());
        follower.addFollowed(followed.getId());

        return new FollowDTO(userId,userIdToFollow, "Following");
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

    @Override
    public FollowersCountDTO getFollowersCount(String userId) throws UserNotFoundException{
        User user= this.findUserByID(userId);

        return new FollowersCountDTO(user.getId(),user.getName(),user.getFollowers().size());
    }
 @Override
    public FollowersDTO getFollowers(String userId) throws UserNotFoundException{
        User user = this.findUserByID(userId);
        List <UserDTO> followerDTO = this.getUserDTOListById(user.getFollowers());
        return new FollowersDTO(user.getId(),user.getName(),followerDTO);
    }

    @Override
    public FollowedByDTO getFollowedBy(String userId) throws UserNotFoundException {
        User user = this.findUserByID(userId);
        List <UserDTO> followedByDTO = this.getUserDTOListById(user.getFollowedBy());
        return new FollowedByDTO(user.getId(),user.getName(),followedByDTO);
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
    private List<UserDTO> getUserDTOListById(List<String> UserIds) throws UserNotFoundException {

        List<UserDTO> userDTOS = new ArrayList<>();

        for (int i = 0; i < UserIds.size(); i++) {

            User user = this.findUserByID(UserIds.get(i));
            userDTOS.add(UserMapper.toDTO(user));

        }

        return userDTOS;

    }

}
