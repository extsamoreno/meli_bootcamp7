package com.example.challenge.Services.DTOs;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {

    private int followerID;
    private int followedID;
    private String type;
}