package com.reto1.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOFollowers{
    int userId;
    String userName;
    ArrayList<UserDTO> followers;
}