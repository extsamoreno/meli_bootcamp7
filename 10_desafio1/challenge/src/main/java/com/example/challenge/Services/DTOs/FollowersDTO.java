package com.example.challenge.Services.DTOs;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersDTO {
    private int id;
    private String userName;
    private List<UserDTO> followers;
}
