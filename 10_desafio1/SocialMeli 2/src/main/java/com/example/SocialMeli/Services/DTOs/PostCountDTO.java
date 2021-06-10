package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class PostCountDTO extends UserDTO {

    private int postCounter;

    public PostCountDTO(int userId, String userName, int postCounter){

        this.setUserId(userId);
        this.setUserName(userName);
        this.setPostCounter(postCounter);
    }


}
