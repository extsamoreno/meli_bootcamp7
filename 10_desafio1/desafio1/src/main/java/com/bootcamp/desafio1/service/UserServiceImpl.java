package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.FollowedListDTO;
import com.bootcamp.desafio1.dto.FollowersListDTO;
import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.User;
import com.bootcamp.desafio1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

        // Validate that the users are not in the Followers and Followed lists, and userId is different to userIdToFollow
        if( !currentUserFollowedList.contains(userToFollow) &&
                !userToFollowFollowersList.contains(currentUser) &&
                (userId != userIdToFollow) ){

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
    public void createUnFollow(int userId, int userIdToUnfollow) throws UserNotFoundException {

        // Get the currentUser and the userToUnfollow
        User currentUser = userRepository.getUserById(userId);
        User userToUnfollow = userRepository.getUserById(userIdToUnfollow);
        ArrayList<User> currentUserFollowedList = currentUser.getFollowed();
        ArrayList<User> userToUnfollowFollowersList = userToUnfollow.getFollowers();

        // Validate that the users are in the Followers and Followed lists, and userId is different to userIdToUnfollow
        if( currentUserFollowedList.contains(userToUnfollow) &&
                userToUnfollowFollowersList.contains(currentUser) &&
                (userId != userIdToUnfollow) ){

            // Remove Follower in userToUnfollow
            userToUnfollow.getFollowers().remove(currentUser);

            // Remove Followed in currentUser
            currentUser.getFollowed().remove(userToUnfollow);

            // Update the Users in the Data Base
            userRepository.updateUserInDB(currentUser);
            userRepository.updateUserInDB(userToUnfollow);
        }
    }


    @Override
    public CountFollowersDTO countFollowers(int id) throws UserNotFoundException {
        User currentUser = userRepository.getUserById(id);
        int followers_count = currentUser.getFollowers().size();
        return Mapper.toCountFollowersDTO(currentUser, followers_count);
    }


    @Override
    public FollowersListDTO listFollowers(int id, String order) throws UserNotFoundException {
        User currentUser = userRepository.getUserById(id);
        ArrayList<User> completeFollowersList = currentUser.getFollowers();
        ArrayList<UserDTO> followers = new ArrayList<>();
        for (User x : completeFollowersList) {
            followers.add(Mapper.toUserDTO(x));
        }

        orderUserName(followers, order);

        return Mapper.toFollowersListDTO(currentUser, followers);
    }


    @Override
    public FollowedListDTO listFollowed(int id, String order) throws UserNotFoundException {
        User currentUser = userRepository.getUserById(id);
        ArrayList<User> completeFollowedList = currentUser.getFollowed();
        ArrayList<UserDTO> followed = new ArrayList<>();
        for (User x : completeFollowedList) {
            followed.add(Mapper.toUserDTO(x));
        }

        orderUserName(followed, order);

        return Mapper.toFollowedListDTO(currentUser, followed);
    }


    public ArrayList<UserDTO> orderUserName(ArrayList<UserDTO> usersList, String order){
        Comparator<UserDTO> NameComparator = (UserDTO a, UserDTO b) -> a.getUserName().compareTo(b.getUserName());
        switch (order){
            case "name_asc":
                Collections.sort( usersList, NameComparator );
                break;

            case "name_desc":
                Collections.sort( usersList, NameComparator );
                Collections.reverse(usersList);
                break;

            case "":
                break;
        }
        return usersList;
    }


}
