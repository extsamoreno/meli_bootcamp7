package com.example.desafio1.service.dto;

import com.example.desafio1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListFollowersDTO {

    private int userId;
    private String userName;
    ArrayList<ResponseUserDTO> followers = new ArrayList<>();
}
