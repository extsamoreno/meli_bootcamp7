package com.springChallenge.api.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FollowerListDTO extends UserDTO{
    private UserDTO[] followers;

    public FollowerListDTO(int userId, String userName, UserDTO[] followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
