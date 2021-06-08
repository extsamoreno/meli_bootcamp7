package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.model.User;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import com.meli.socialmeli.service.dto.UserDTOSimpleUser;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTOFollowersCount toUserFollowerCount(User user){
        UserDTOFollowersCount responseUser= new UserDTOFollowersCount();
        responseUser.setUserId(user.getUserId());
        responseUser.setUserName(user.getUserName());
        responseUser.setFollowers_count((int) user.getFollowers().stream().count());
        return responseUser;
    }
    public static UserDTOFollowersList toUserFollowerList(User user){
        UserDTOFollowersList responseUser= new UserDTOFollowersList();
        responseUser.setUserId(user.getUserId());
        responseUser.setUserName(user.getUserName());
        List<User> followers= user.getFollowers();
        List<UserDTOSimpleUser> newFollowersList= new ArrayList<>();
        for (int i = 0; i < followers.size(); i++) {
            newFollowersList.add(UserMapper.toSimpleUser(followers.get(i)));
        }
        responseUser.setFollowers(newFollowersList);
        return responseUser;
    }

    public static UserDTOFollowedList toUserFollowedList(User user){
        UserDTOFollowedList responseUser= new UserDTOFollowedList();
        responseUser.setUserId(user.getUserId());
        responseUser.setUserName(user.getUserName());
        List<User> followers= user.getFollowed();
        List<UserDTOSimpleUser> newFollowersList= new ArrayList<>();
        for (int i = 0; i < followers.size(); i++) {
            newFollowersList.add(UserMapper.toSimpleUser(followers.get(i)));
        }
        responseUser.setFollowed(newFollowersList);
        return responseUser;
    }

    public static UserDTOSimpleUser toSimpleUser(User user){
        UserDTOSimpleUser responseUser= new UserDTOSimpleUser();
        responseUser.setUserId(user.getUserId());
        responseUser.setUserName(user.getUserName());
        return responseUser;
    }
}
