package com.Desafio1.SocialMeli.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerCountDTO {
    private int userId;
    private String userName;
    private int followerCount;
}
