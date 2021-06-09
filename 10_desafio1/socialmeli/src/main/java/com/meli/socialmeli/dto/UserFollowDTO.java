package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFollowDTO {
    private int userId;
    private String userIdToFollow;
    //private String typeOfFollow;
}
