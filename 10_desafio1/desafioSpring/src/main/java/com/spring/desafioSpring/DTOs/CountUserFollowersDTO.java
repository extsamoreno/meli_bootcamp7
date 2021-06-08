package com.spring.desafioSpring.DTOs;

import lombok.*;

@Getter @Setter
public class CountUserFollowersDTO {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
