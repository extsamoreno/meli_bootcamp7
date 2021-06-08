package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOFollowersCount {
    private int userId;
    private String userName;
    private int followers_count;
}
