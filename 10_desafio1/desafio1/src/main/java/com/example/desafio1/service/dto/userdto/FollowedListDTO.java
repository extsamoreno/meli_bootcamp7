package com.example.desafio1.service.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedListDTO {
    private int userId;
    private String userName;
    private ArrayList<FollowedDTO> followed;
}
