package com.example.DesafioSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
public class FollowDTO {
    private int followerID;
    private int followedBy;
    private String typeOfFollowing;
}
