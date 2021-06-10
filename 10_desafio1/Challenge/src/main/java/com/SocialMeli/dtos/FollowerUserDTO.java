package com.SocialMeli.dtos;

import com.SocialMeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class FollowerUserDTO {
    private Integer userId;
    private String userName;
    private ArrayList<User> follower;

}
