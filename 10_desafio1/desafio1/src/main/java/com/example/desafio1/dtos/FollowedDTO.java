package com.example.desafio1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedDTO {
    private int userId;
    private String userName;
    private List<MeliUserDTO> followed;
}
