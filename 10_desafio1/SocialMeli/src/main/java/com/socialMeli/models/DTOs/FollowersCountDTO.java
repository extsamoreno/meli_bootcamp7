package com.socialMeli.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersCountDTO {

    private Integer userId;
    private String username;
    private Integer followersCount;
}
