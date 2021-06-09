package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowDTO {
    private int userId;
    private String userIdToFollow;
    //private String typeOfFollow;
}
