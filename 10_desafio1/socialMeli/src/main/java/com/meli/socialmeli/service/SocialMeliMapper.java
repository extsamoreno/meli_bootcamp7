package com.meli.socialmeli.service;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.UserWithFollowersDTO;
import com.meli.socialmeli.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;


public class SocialMeliMapper {

    public static UserWithFollowersCountDTO toFollowersCountDTO(User user) {
        Integer count = user.getFollowers().size();
        return new UserWithFollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }

    public static UserWithFollowersDTO toFollowersDTO(User user) {
        return new UserWithFollowersDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowers()));
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        return list.stream().map(SocialMeliMapper::toUserDTO).collect(Collectors.toList());
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}
