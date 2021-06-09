package com.example.demo.services;

import com.example.demo.DTO.FollowedListDTO;
import com.example.demo.DTO.FollowersCountDTO;
import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices implements IUserServices {

    final static String ORDER_NAME_ASCE ="name_asc";
    final static String ORDER_NAME_DESC ="name_desc";

    @Autowired
    IGeneralRepository userRepository;



    public void follow(Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        UserDTO userToFollow = userRepository.findById(userIdToFollow);

        userRepository.follow(user,userToFollow);
    }

    @Override
    public FollowersCountDTO countFollowers(Integer userId) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        FollowersCountDTO followersCount = new FollowersCountDTO(user);
        followersCount.setFollowers_count(userRepository.countFollowers(user));
        return followersCount;
    }

    @Override
    public FollowersListDTO followersList(Integer userId, String order) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userId);
        FollowersListDTO followersList = new FollowersListDTO(user);
        List<UserDTO> userList = userRepository.followersList(userId);

        if(order.equals(ORDER_NAME_ASCE)){
            userList = userList.stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName))
                    .collect(Collectors.toList());
        }else if (order.equals(ORDER_NAME_DESC)){
            userList = userList.stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName).reversed())
                    .collect(Collectors.toList());
        }
        followersList.setFollowers(userList);
        return followersList;
    }

    @Override
    public FollowedListDTO followedList(Integer userID, String order) throws UserNotFoundException {
        UserDTO user = userRepository.findById(userID);
        FollowedListDTO followedList = new FollowedListDTO(user);
        List<UserDTO> userList = userRepository.followedList(userID);

        if(order.equals(ORDER_NAME_ASCE)){
            userList = userList.stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName))
                    .collect(Collectors.toList());
        }else if (order.equals(ORDER_NAME_DESC)){
            userList = userList.stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName).reversed())
                    .collect(Collectors.toList());
        }
        followedList.setFollowed(userList);
        return followedList;
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) throws GenericException {
        UserDTO user = userRepository.findById(userId);
        UserDTO userToUnfollow = userRepository.findById(userIdToUnfollow);
        userRepository.unfollow(user,userToUnfollow);
    }
}
