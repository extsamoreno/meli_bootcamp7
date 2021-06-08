package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private ArrayList<UserDTO> followers;
    private ArrayList<UserDTO> followed;

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
