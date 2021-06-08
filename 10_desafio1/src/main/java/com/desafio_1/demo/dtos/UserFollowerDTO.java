package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowerDTO {
    private Integer id;
    private String userName;
    private ArrayList<UserFollowerDTO> followers;

    public UserFollowerDTO(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
