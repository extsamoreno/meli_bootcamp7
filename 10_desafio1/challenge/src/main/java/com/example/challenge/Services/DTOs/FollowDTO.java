package com.example.challenge.Services.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {

    private int followerID;
    private int followedID;
    private String type;
}