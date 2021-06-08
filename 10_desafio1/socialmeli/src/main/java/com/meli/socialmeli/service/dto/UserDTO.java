package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO extends UserBaseDTO {

    private List<UserBaseDTO> following;

    public UserDTO(Integer userId, String userName, List<UserBaseDTO> following) {
        super(userId, userName);
        this.following = following;
    }
}
