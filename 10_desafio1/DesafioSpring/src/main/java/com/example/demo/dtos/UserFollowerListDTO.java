package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerListDTO {

    private int userId;
    private String userName;
    private ArrayList<UserResponseDTO> followers=new ArrayList<>();

}
