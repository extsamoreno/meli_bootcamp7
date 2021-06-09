package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FollowersListDTO extends UserDTO {

    private ArrayList<UserDTO> followers;

    public FollowersListDTO(int userId, String userName, ArrayList<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
