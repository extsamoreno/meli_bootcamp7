package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.mappers.UserMapper;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
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
public class UserRepositoryImple implements UserRepository {
    private List<User> users = new ArrayList<>();
    private int count = 0;

    @Override
    public UserDTO addUser(NewUserRequestDTO newUser) throws ExistentUserException {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(newUser.getUserName())){
                throw new ExistentUserException(newUser.getUserName());
            }
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(count);
        userDTO.setUserName(newUser.getUserName());

        User user = UserMapper.DTOToUser(userDTO);

        users.add(user);
        count++;

        return userDTO;
    }

    @Override
    public FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException {
        User user = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);
        FollowSellerResponseDTO modifiedUser = new FollowSellerResponseDTO();

        for (int i = 0; i < users.size(); i++) {
            User dbUser = users.get(i);

            if(dbUser.getFollowed().size() == 0){
                continue;
            } else {
                for (int j = 0; j < dbUser.getFollowed().size(); j++) {
                    UserDTO followed = dbUser.getFollowed().get(j);

                    if(followed.getUserId() == userIdToFollow){
                        throw new ExistentFollowerException(userId, userIdToFollow);
                    }
                }
            }
        }

        user.addFollowed(UserMapper.UserToDTO(userToFollow));
        userToFollow.addFollower(UserMapper.UserToDTO(user));

        modifiedUser.setUserId(user.getUserId());
        modifiedUser.setUserName(user.getUserName());
        modifiedUser.setFollowed(user.getFollowed());

        return modifiedUser;
    }
    
    @Override
    public User getUserById(int userId) throws InexistentUserException {
        try{
            User foundUser = users.get(userId);

            return foundUser;
        } catch (Exception e){
            throw new InexistentUserException(userId);
        }
    }
    
    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> dtoUsers = null;

        for(User user : users){
            dtoUsers.add(UserMapper.UserToDTO(user));
        }
        
        return dtoUsers;
    }

    @Override
    public FollowersCountResponseDTO countResponse(int userId) throws InexistentUserException {
        User user = getUserById(userId);
        FollowersCountResponseDTO followersCountResponseDTO = new FollowersCountResponseDTO();

        followersCountResponseDTO.setUserId(userId);
        followersCountResponseDTO.setUserName(user.getUserName());
        followersCountResponseDTO.setFollowersCount(user.getFollowers().size());

        return followersCountResponseDTO;
    }

    /*private List<User> loadDateBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>(){};
        List<User> userList = null;

        try {
            userList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }*/
}
