package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.FollowersListDTO;
import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.User;
import com.bootcamp.desafio1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements  IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void createFollow(int userId, int userIdToFollow) throws UserNotFoundException {

        // Get the currentUser and the userToFollow
        User currentUser = userRepository.getUserById(userId);
        User userToFollow = userRepository.getUserById(userIdToFollow);
        ArrayList<User> currentUserFollowedList = currentUser.getFollowed();
        ArrayList<User> userToFollowFollowersList = userToFollow.getFollowers();

        // Validate that the users are not in the Followers and Followed lists
        if( !currentUserFollowedList.contains(userToFollow) && !userToFollowFollowersList.contains(currentUser)){
            // Add Follower to userToFollow
            userToFollow.getFollowers().add(currentUser);

            // Add Followed to currentUser
            currentUser.getFollowed().add(userToFollow);

            // Update the Users in the Data Base
            userRepository.updateUserInDB(currentUser);
            userRepository.updateUserInDB(userToFollow);
        }
    }

    @Override
    public CountFollowersDTO countFollowers(int id) throws UserNotFoundException {
        User currentUser = userRepository.getUserById(id);
        int followers_count = currentUser.getFollowers().size();
        return Mapper.toCountFollowersDTO(currentUser, followers_count);
    }

    @Override
    public FollowersListDTO listFollowers(int id) throws UserNotFoundException {
        User currentUser = userRepository.getUserById(id);
        ArrayList<User> completeFollowersList = currentUser.getFollowers();
        ArrayList<UserDTO> followers = new ArrayList<>();
        for (User x : completeFollowersList) {
            followers.add(Mapper.toUserDTO(x));
        }
        return Mapper.toFollowersListDTO(currentUser, followers);
    }


}
