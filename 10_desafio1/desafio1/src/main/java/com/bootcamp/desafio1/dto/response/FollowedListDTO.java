package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FollowedListDTO extends UserDTO {

    private ArrayList<UserDTO> followed;

    public FollowedListDTO(int userId, String userName, ArrayList<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
