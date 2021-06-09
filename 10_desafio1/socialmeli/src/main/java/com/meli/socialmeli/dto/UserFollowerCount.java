package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowerCount {
    private int userId;
    private String UserName;
    private int followersCount;

    public UserFollowerCount(int userId, String userName) {
        this.userId = userId;
        UserName = userName;
    }
}
