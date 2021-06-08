package com.example.demo.services.mapper;

import com.example.demo.model.DTO.FollowersListDTO;
import com.example.demo.model.DTO.ResponseCountDTO;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapper {

    public FollowersListDTO toFollowersListDTO(String userName, int id, List<UserDTO> followers){
        return new FollowersListDTO(userName, id, followers);
    }

    public ResponseCountDTO toCountDTO(int id, String username, int i){
        return new ResponseCountDTO(username, id, i);
    }

    public UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getUserName());
    }

}
