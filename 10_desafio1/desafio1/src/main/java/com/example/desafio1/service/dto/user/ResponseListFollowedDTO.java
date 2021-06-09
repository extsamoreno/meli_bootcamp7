package com.example.desafio1.service.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListFollowedDTO {

    private int userId;
    private String userName;
    ArrayList<ResponseUserDTO> followed = new ArrayList<>();
}



