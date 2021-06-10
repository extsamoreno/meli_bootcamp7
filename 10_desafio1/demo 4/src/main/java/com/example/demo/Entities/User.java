package com.example.demo.entities;

import com.example.demo.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<UserDTO> followers;
}
