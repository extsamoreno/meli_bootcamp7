package com.example.demo.services;

import com.example.demo.model.DTO.FollowedListDTO;
import com.example.demo.model.DTO.FollowersListDTO;
import com.example.demo.model.DTO.ResponseCountDTO;
import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.services.mapper.Mapper;
import com.example.demo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserServices{

    @Autowired
    Mapper mapper;

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean followUser(int userId, int userIdToFollow) {
        User followedUser = userRepository.getUserById(userIdToFollow);
        User followingUser = userRepository.getUserById(userId);
        followingUser.addFollowed(mapper.toDTO(followedUser));
        followedUser.addFollower(mapper.toDTO(followingUser));
        System.out.println(userRepository.getUserById(userId).getUserName() + " is now following " + userRepository.getUserById(userIdToFollow).getUserName());
        return true;
    }

    @Override
    public ResponseCountDTO getFollowersCount(int userId) {
        User user = userRepository.getUserById(userId);
        return mapper.toCountDTO(user.getId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public FollowersListDTO getFollowersList(int userId) {
        User user = userRepository.getUserById(userId);
        return mapper.toFollowersListDTO(user.getUserName(), user.getId(), user.getFollowers());
    }

    @Override
    public FollowedListDTO getFollowedList(int userId) {
        User user = userRepository.getUserById(userId);
        return mapper.toFollowedListDTO(user.getUserName(), user.getId(), user.getFollowed());
    }

    @Override
    public boolean unfollow(int userId, int userIdToUnfollow) {
        User user1 = userRepository.getUserById(userId);
        User user2 = userRepository.getUserById(userIdToUnfollow);

        for (int i = 0; i < user2.getFollowers().size(); i++) {
            if(user2.getFollowers().get(i).getId() == userId){
                user2.removeFollower(user2.getFollowers().get(i));
                break;
            }
        }

        for (int i = 0; i < user1.getFollowed().size(); i++) {
            if(user1.getFollowed().get(i).getId() == userIdToUnfollow){
                user1.removeFollowed(user1.getFollowed().get(i));
                break;
            }
        }

        System.out.println(user1.getUserName() + " is no longer following " + user2.getUserName());
        return true;
    }


}
