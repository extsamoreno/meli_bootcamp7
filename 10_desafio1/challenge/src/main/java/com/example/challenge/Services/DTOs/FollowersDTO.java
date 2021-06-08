package com.example.challenge.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersDTO {
    private int id;
    private String userName;
    private List<UserDTO> followers;
}
