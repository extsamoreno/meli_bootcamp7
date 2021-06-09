package com.meli.socialmeli.service;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;

import java.util.List;
import java.util.stream.Collectors;


public class UserMapper {

    public static UserWithFollowersCountDTO toFollowersCountDTO(User user) {
        Integer count = user.getFollowers().size();
        return new UserWithFollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }

    public static UserWithFollowersDTO toFollowersDTO(User user) {
        return new UserWithFollowersDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowers()));
    }

    public static UserWithFollowedDTO toFollowedDTO(User user) {
        return new UserWithFollowedDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowed()));
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        return list.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }


}
