package com.SocialMeli.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public

//Cantidad de seguidores

class FollowersCountDTO {
    int userId;
    String userName;
    long followers_count = 0;

    public FollowersCountDTO(int userId, String userName, long followers_count) {
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }
}