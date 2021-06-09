package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountFollowersDTO extends UserDTO {

    private int followersCount;

    public CountFollowersDTO(int userId, String userName, int followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
