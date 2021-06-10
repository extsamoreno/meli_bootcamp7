package com.example.challenge.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedDTO {

    private int id;
    private String userName;
    private List<UserDTO> followed;

}
