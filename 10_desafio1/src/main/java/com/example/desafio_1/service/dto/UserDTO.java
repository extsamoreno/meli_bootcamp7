package com.example.desafio_1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;
    private int followers_count;
    private List<UserDTO> followers;
}
