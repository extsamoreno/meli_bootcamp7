package com.example.desafio1.service;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.IUserRepository;
import com.example.desafio1.service.dto.userdto.*;
import com.example.desafio1.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;


    @Override
    public String followUser(int userId, int userIdToFollow) throws UserNotFoundException {
        User userFollower = iUserRepository.getUserById(userId);
        User userFollowed = iUserRepository.getUserById(userIdToFollow);
        follow(userFollower, userFollowed);

        return "Todo OK";
    }

    private void follow(User user, User userTofollow) {
        addFollowed(user, userTofollow);
        addFollower(userTofollow, user);
    }

    private void addFollower(User user, User follower) {
        user.getFollowers().add(follower.getId());
    }

    private void addFollowed(User user, User followed) {
        user.getFollowed().add(followed.getId());
    }

    @Override
    public String unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException {
        User userFollower = iUserRepository.getUserById(userId);
        User userFollowed = iUserRepository.getUserById(userIdToUnfollow);
        unfollow(userFollower, userFollowed);

        return "Todo OK";
    }

    private void unfollow(User user, User userToUnfollow) {
        removeFollowed(user, userToUnfollow);
        removeFollower(userToUnfollow, user);
    }

    private void removeFollower(User user, User follower) {
        ArrayList<Integer> followers = user.getFollowers();
        followers.remove((Integer) follower.getId());
    }

    private void removeFollowed(User user, User followed) {
        ArrayList<Integer> followedUsers = user.getFollowed();
        followedUsers.remove((Integer) followed.getId());
    }

    @Override
    public ArrayList<User> getUsersList() {
        return iUserRepository.getUsersList();
    }

    @Override
    public FollowersCountDTO getFollowersCountDTO(int userId) throws UserNotFoundException{
        User user = iUserRepository.getUserById(userId);

        return UserMapper.toFollowersCountDTO(user, user.getFollowers().size());
    }

    @Override
    public FollowersListDTO getFollowersListDTO(int userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getUserById(userId);
        ArrayList<Integer> followersId = user.getFollowers();
        ArrayList<FollowerDTO> followerDTOS = new ArrayList<>();
        for (Integer followerId :
                followersId) {
            FollowerDTO followerDTO = UserMapper.toFollowerDTO(iUserRepository.getUserById(followerId));
            followerDTOS.add(followerDTO);
        }

        if (order.equalsIgnoreCase("name_asc"))
        {
            followerDTOS.sort(Comparator.comparing((FollowerDTO::getUserName)));
        }
        else if (order.equalsIgnoreCase("name_desc"))
        {
            followerDTOS.sort(Collections.reverseOrder(Comparator.comparing((FollowerDTO::getUserName))));
        }

        return UserMapper.toFollowersListDTO(user, followerDTOS);
    }



    @Override
    public FollowedListDTO getFollowedListDTO(int userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getUserById(userId);
        ArrayList<Integer> followedIds = user.getFollowed();
        ArrayList<FollowedDTO> followedDTOS = new ArrayList<>();
        for (Integer followedId :
                followedIds) {
            FollowedDTO followedDTO = UserMapper.toFollowedDTO(iUserRepository.getUserById(followedId));
            followedDTOS.add(followedDTO);
        }

        if (order.equalsIgnoreCase("name_asc"))
        {
            followedDTOS.sort(Comparator.comparing((FollowedDTO::getUserName)));
        }
        else if (order.equalsIgnoreCase("name_desc"))
        {
            followedDTOS.sort(Collections.reverseOrder(Comparator.comparing((FollowedDTO::getUserName))));
        }

        return UserMapper.toFollowedListDTO(user, followedDTOS);
    }


}
