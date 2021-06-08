package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class FollowedByDTO extends Following{
    private List<UserDTO> followedBy;

    public FollowedByDTO(String userId, String userName, List <UserDTO> followedBy){
        super(userId,userName);
        this.setUserId(userId);
        this.setFollowedBy(followedBy);
    }
}
