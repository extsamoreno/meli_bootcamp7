package com.example.DesafioSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
public class FollowDTO {
    private String userId;
    private String userIdToFollow;
    private String typeOfFollow;
}
