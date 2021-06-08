package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.MeliUserDTO;
import com.example.desafio1.models.MeliUser;

import java.util.ArrayList;
import java.util.List;

public class MeliUserMapper {
    public static List<MeliUserDTO> toDTOList(List<MeliUser> userList){
        List<MeliUserDTO> meliUserDTOList = new ArrayList<>();
        MeliUserDTO user;
        for (MeliUser meliUser : userList) {
            user = new MeliUserDTO();
            user.setUserId(meliUser.getUserId());
            user.setUserName(meliUser.getUserName());
            meliUserDTOList.add(user);
        }

        return meliUserDTOList;
    }
}
