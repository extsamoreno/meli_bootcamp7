package com.desafio.SocialMeli.Mapper;

import com.desafio.SocialMeli.Classes.User;
import com.desafio.SocialMeli.DTO.FollowedListDTO;
import com.desafio.SocialMeli.DTO.FollowersCountDTO;
import com.desafio.SocialMeli.DTO.FollowersListDTO;
import com.desafio.SocialMeli.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static User ToUser(UserDTO userDTO){
        return new User(userDTO.getUserId());
    }

    public static FollowersCountDTO toFollowersCountDTO(User user){
        return new FollowersCountDTO(user.getUserId(), user.getUserName(), user.getFollowersCount());
    }

    public static FollowersListDTO toFollowersListDTO(User user){
        return new FollowersListDTO(user.getUserId(), user.getUserName(), toListUserDTO(user.getFollowers()));
    }

    public static FollowedListDTO toFollowedListDTO(User user){
        return new FollowedListDTO(user.getUserId(), user.getUserName(), toListUserDTO(user.getFollowed()));
    }

    public static List<UserDTO> toListUserDTO(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(toDTO(user));
        }
        return userDTOList;
    }
}
