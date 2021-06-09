package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class FollowedByDTO extends Following{
    private List<UserDTO> followed;

    public FollowedByDTO(int userId, String userName, List <UserDTO> followed){
        super(userId,userName);
        this.setUserId(userId);
        this.setFollowed(followed);
    }
}
