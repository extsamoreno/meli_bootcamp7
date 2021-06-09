package com.example.desafio1.service.mapper;

import com.example.desafio1.model.User;
import com.example.desafio1.service.dto.user.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseUserDTO;

import java.util.ArrayList;

public class UserMapper {

    // User to ResponseUserDTO
    public static ResponseUserDTO toUserDTO(User user){

        ResponseUserDTO userDTO = new ResponseUserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        /*userDTO.setSeller(user.isSeller());
        userDTO.setFollowers(user.getFollowers());
        userDTO.setFollows(user.getFollows());*/

        return userDTO;
    }

    // userDTO to User
    public static User toUser(ResponseUserDTO userDTO){

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        /*user.setSeller(userDTO.isSeller());
        user.setFollowers(userDTO.getFollowers());
        user.setFollows(userDTO.getFollows());*/

        return user;
    }

    // User to ResponseCountFollowersDTO
    public static ResponseCountFollowersDTO toResponseCountFollowersDTO(User user, Integer count){
        return new ResponseCountFollowersDTO(user.getUserId(), user.getUserName(), count);
    }

    // User to ResponseListFollowersDTO
    public static ResponseListFollowersDTO toResponseListFollowersDTO(User user){

        ArrayList<ResponseUserDTO> listUserDTO = new ArrayList<>();

        for (User us : user.getFollowers()) {
            listUserDTO.add(new ResponseUserDTO(us.getUserId(), us.getUserName()));
        }
        return new ResponseListFollowersDTO(user.getUserId(), user.getUserName(), listUserDTO);
    }

    // User to ResponseListFollowedDTO
    public static ResponseListFollowedDTO toResponseListFollowedDTO(User user) {

        ArrayList<ResponseUserDTO> listUserDTO = new ArrayList<>();

        for (User us : user.getFollows()) {
            listUserDTO.add(new ResponseUserDTO(us.getUserId(), us.getUserName()));
        }
        return new ResponseListFollowedDTO(user.getUserId(), user.getUserName(), listUserDTO);
    }
}
