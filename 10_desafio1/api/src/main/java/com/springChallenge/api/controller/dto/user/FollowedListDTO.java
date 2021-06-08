package com.springChallenge.api.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FollowedListDTO extends UserDTO{
    private UserDTO[] followed;

    public FollowedListDTO(int userId, String userName, UserDTO[] followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
