package com.socialmeli.desafio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO {
    private int userId;
    private String userName;
    private int follewersCount;


}
