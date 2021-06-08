package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.models.MeliUser;

import java.util.ArrayList;
import java.util.List;

public class MeliUserMapper {
    public static List<UserDTO> toDTOList(List<MeliUser> userList){
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO user;
        for (MeliUser meliUser : userList) {
            user = new UserDTO();
            user.setUserId(meliUser.getUserId());
            user.setUserName(meliUser.getUserName());
            userDTOList.add(user);
        }

        return userDTOList;
    }
}
