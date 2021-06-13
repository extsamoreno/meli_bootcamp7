package com.desafio.socialMeli.model.mapper;

import com.desafio.socialMeli.model.dao.models.User;
import com.desafio.socialMeli.model.dto.UserDTO;
import com.desafio.socialMeli.model.dto.UserFollowedDTO;
import com.desafio.socialMeli.model.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.model.dto.UserFollowersDTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMapper {
    public static UserFollowersCountDTO toUserFollowersCountDTO(UserDTO userDTO, Integer userId){
        return new UserFollowersCountDTO(userId,userDTO.getName(),userDTO.getFollowerList().size());
    }

    public static UserFollowersDTO toUserFollowersDTO(UserDTO userDTO, Integer userId) {
        List<User> followers = new ArrayList<User>();
        UserFollowersDTO userFollowersDTO = new UserFollowersDTO();

        for(User u: userDTO.getFollowerList())
            followers.add(u);

        userFollowersDTO.setFollowers(followers);
        userFollowersDTO.setUserId(userId);
        userFollowersDTO.setUserName(userDTO.getName());

        return userFollowersDTO;
    }

    public static UserFollowedDTO toUserFollowedListDTO(UserDTO userDTO, Integer userId) {
        List<User> followedList = new ArrayList<User>();
        UserFollowedDTO userFollowedDTO = new UserFollowedDTO();

        for(User u: userDTO.getFollowedList())
            followedList.add(u);

        userFollowedDTO.setFollowedList(followedList);
        userFollowedDTO.setUserId(userId);
        userFollowedDTO.setUserName(userDTO.getName());

        return userFollowedDTO;
    }
}