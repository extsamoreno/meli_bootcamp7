package com.meli.socialmeli.mapper;

import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserMapper {

    public static List<UserDTO> mapFollowers(User user) {

        List<UserDTO> followers = new ArrayList<>();

        for (Map.Entry<Integer, User> entry : user.getFollowers().entrySet()) {

            UserDTO follower = new UserDTO();
            follower.setUserId(entry.getKey());
            follower.setUserName(entry.getValue().getUserName());
            followers.add(follower);
        }
        return followers;
    }

    public static  List<UserDTO> mapFollowed(User user) {

        List<UserDTO> followedList = new ArrayList<>();

        for (Map.Entry<Integer, User> entry : user.getFollowed().entrySet()) {

            UserDTO followed = new UserDTO();
            followed.setUserId(entry.getKey());
            followed.setUserName(entry.getValue().getUserName());

            followedList.add(followed);
        }
        return followedList;
    }



}
