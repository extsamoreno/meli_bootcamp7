package com.example.socialmeli.services;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import com.example.socialmeli.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public NewUserResponseDTO addUser(NewUserRequestDTO newUserRequestDTO) throws ExistentUserException {
        NewUserResponseDTO createdUser = new NewUserResponseDTO();
        UserDTO createdUserRespository = userRepository.addUser(newUserRequestDTO);

        createdUser.setUserId(createdUserRespository.getUserId());
        createdUser.setUserName(createdUserRespository.getUserName());

        return createdUser;
    }

    @Override
    public FollowSellerResponseDTO followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException, InvalidFollowerException {
        if(userId == userIdToFollow){
            throw new InvalidFollowerException();
        }

        FollowSellerResponseDTO modifiedUser = userRepository.followSeller(userId, userIdToFollow);

        return modifiedUser;
    }

    @Override
    public FollowersCountResponseDTO countFollowers(int userId) throws InexistentUserException {
        FollowersCountResponseDTO countResponse = userRepository.countResponse(userId);

        return countResponse;
    }

    @Override
    public ListFollowersResponseDTO listFollowers(int userId, String order) throws InexistentUserException, InexistentNameOrderException {
        if(!order.matches("name_asc|name_desc")){
            throw new InexistentNameOrderException(order);
        }

        ListFollowersResponseDTO userResponse = userRepository.listFollowers(userId);

        switch (order) {
            case "name_asc":
                Collections.sort(userResponse.getFollowers(), Comparator.comparing(UserDTO::getUserName));
                break;
            case "name_desc":
                Collections.sort(userResponse.getFollowers(), Comparator.comparing(UserDTO::getUserName));
                Collections.reverse(userResponse.getFollowers());
                break;
        }

        return userResponse;
    }

    @Override
    public ListFollowedResponseDTO listFollowed (int userId, String order) throws InexistentUserException, InexistentNameOrderException {
        if(!order.matches("name_asc|name_desc")){
            throw new InexistentNameOrderException(order);
        }

        ListFollowedResponseDTO userResponse = userRepository.listFollowed(userId);

        switch (order) {
            case "name_asc":
                Collections.sort(userResponse.getFollowed(), Comparator.comparing(UserDTO::getUserName));
                break;
            case "name_desc":
                Collections.sort(userResponse.getFollowed(), Comparator.comparing(UserDTO::getUserName));
                Collections.reverse(userResponse.getFollowed());
        }

        return userResponse;
    }

    @Override
    public FollowSellerResponseDTO unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException{
        FollowSellerResponseDTO modifiedUser = userRepository.unfollowSeller(userId, userIdToUnfollow);

        return modifiedUser;
    }

}
