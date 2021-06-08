package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersCountDTO {

    private int userId;
    private String userName;
    private int followers_count;

    public UserFollowersCountDTO(int userId,String userName){
        this.userId=userId;
        this.userName=userName;
    }

}
