package com.desafio.SocialMeli.Mapper;

import com.desafio.SocialMeli.Model.User;
import com.desafio.SocialMeli.DTO.User.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static User ToUser(UserDTO userDTO){
        return new User(userDTO.getUserId());
    }

    public static List<UserDTO> toListUserDTO(List<User> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(toDTO(user));
        }
        return userDTOList;
    }
}
