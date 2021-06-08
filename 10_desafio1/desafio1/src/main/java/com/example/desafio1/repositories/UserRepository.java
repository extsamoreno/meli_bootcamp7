package com.example.desafio1.repositories;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.mappers.UserMapper;
import com.example.desafio1.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    protected HashMap<Integer, User> users = new HashMap<>();

    @Override
    public String createDB() {
        List<User> users = loadDateBase();
        for(User u : users) {
            this.users.put(u.getUserId(), u);
        }
        return "Base de datos inicializada";
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        User user = users.get(userId);
        if(user == null) {
            throw new InvalidUserIdException(userId);
        }
        return user;
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws InvalidUserIdException {
        User user = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);
        user.addFollowed(UserMapper.UserToDTO(userToFollow));
        userToFollow.addFollower(UserMapper.UserToDTO(user));
        return userId + " ha seguido a " + userIdToFollow;
    }

    @Override
    public ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        User user = getUserById(userId);
        ResponseFollowerCountDTO responseFollowerCountDTO = new ResponseFollowerCountDTO();
        responseFollowerCountDTO.setUserId(user.getUserId());
        responseFollowerCountDTO.setUserName(user.getUserName());
        responseFollowerCountDTO.setFollowers_count(user.getFollowers().size());
        return responseFollowerCountDTO;
    }

    @Override
    public ResponseFollowerListDTO getFollowers(int userId) throws InvalidUserIdException {
        User user = getUserById(userId);
        ResponseFollowerListDTO responseFollowerListDTO = new ResponseFollowerListDTO();
        responseFollowerListDTO.setUserId(user.getUserId());
        responseFollowerListDTO.setUserName(user.getUserName());
        responseFollowerListDTO.setFollowers(user.getFollowers());
        return responseFollowerListDTO;
    }

    @Override
    public ResponseFollowedSellerDTO getFollowedSellers(int userId) throws InvalidUserIdException {
        User user = getUserById(userId);
        ResponseFollowedSellerDTO responseFollowedSellerDTO = new ResponseFollowedSellerDTO();
        responseFollowedSellerDTO.setUserId(user.getUserId());
        responseFollowedSellerDTO.setUserName(user.getUserName());
        responseFollowedSellerDTO.setFollowed(user.getFollowed());
        return responseFollowedSellerDTO;
    }

    private List<User> loadDateBase() {
        File file = null;
        try {                                           // need to change to user.json
            file = ResourceUtils.getFile("classpath:newUsers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>(){};
        List<User>  userList = null;
        try {
            userList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
