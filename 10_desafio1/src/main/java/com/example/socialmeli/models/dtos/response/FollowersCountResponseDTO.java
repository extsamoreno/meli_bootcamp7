package com.example.socialmeli.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowersCountResponseDTO {
    private int userId;
    private String userName;
    private int followersCount;
}
