package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO extends UserDTO{

    private Integer followers_count;

    public FollowersCountDTO (UserDTO user){
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.followers_count = 0;
    }

}
