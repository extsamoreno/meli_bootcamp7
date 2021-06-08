package com.spring.desafioSpring.DTOs;

import lombok.*;

import java.util.List;

@Getter @Setter
public class FollowersUserDTO {
    private Integer userId;
    private String userName;
    private List<UserIdNameDTO> followers;
}
