package com.meli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountUserFollowerDTO {
    private int userIdCount;
    private String userNameCount;
    private int countFollower;
}
