package com.example.desafiospring.socialmeli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class UserFollowDTO {
    int userId;
    String userName;
    private ArrayList<UserDTO> followList;
}
