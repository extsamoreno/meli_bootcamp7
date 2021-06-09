package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.exceptions.InexistentFollowerException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.mappers.UserMapper;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowersResponseDTO;
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

            if(dbUser.getUserId() == userId){
                for (int j = 0; j < dbUser.getFollowed().size(); j++) {
                    UserDTO followed = dbUser.getFollowed().get(j);

                    if(followed.getUserId() == userIdToFollow){
                        throw new ExistentFollowerException(userId, userIdToFollow);
                    }
                }
                break;
            } else {
                continue;
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

    @Override
    public ListFollowersResponseDTO listFollowers(int userId) throws InexistentUserException{
        User user = getUserById(userId);
        ListFollowersResponseDTO listFollowersResponseDTO = new ListFollowersResponseDTO();

        listFollowersResponseDTO.setUserId(userId);
        listFollowersResponseDTO.setUserName(user.getUserName());
        listFollowersResponseDTO.setFollowers(user.getFollowers());

        return listFollowersResponseDTO;
    }

    @Override
    public ListFollowedResponseDTO listFollowed (int userId) throws InexistentUserException{
        User user = getUserById(userId);
        ListFollowedResponseDTO listFollowedResponseDTO = new ListFollowedResponseDTO();

        listFollowedResponseDTO.setUserId(userId);
        listFollowedResponseDTO.setUserName(user.getUserName());
        listFollowedResponseDTO.setFollowed(user.getFollowed());

        return listFollowedResponseDTO;
    }

    @Override
    public FollowSellerResponseDTO unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException{
        User user = getUserById(userId);
        User userToUnfollow = getUserById(userIdToUnfollow);
        UserDTO followedUser = null;
        UserDTO followerUser = null;
        FollowSellerResponseDTO modifiedUser = new FollowSellerResponseDTO();
        boolean followerNotFound = true;

        for (int i = 0; i < users.size(); i++) {
            User dbUser = users.get(i);

            if(dbUser.getUserId() == userId){
                for (int j = 0; j < dbUser.getFollowed().size(); j++) {
                    followedUser = dbUser.getFollowed().get(j);

                    if(followedUser.getUserId() == userIdToUnfollow){
                        for (int k = 0; k < userToUnfollow.getFollowers().size(); k++) {
                            followerUser = userToUnfollow.getFollowers().get(k);

                            if(followerUser.getUserId() == userId){
                                followerNotFound = false;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            } else {
                continue;
            }
        }

        if(followerNotFound){
            throw new InexistentFollowerException(userId, userIdToUnfollow);
        }

        user.deleteFollowed(followedUser);
        userToUnfollow.deleteFollower(followerUser);

        modifiedUser.setUserId(user.getUserId());
        modifiedUser.setUserName(user.getUserName());
        modifiedUser.setFollowed(user.getFollowed());

        return modifiedUser;
    }

}
