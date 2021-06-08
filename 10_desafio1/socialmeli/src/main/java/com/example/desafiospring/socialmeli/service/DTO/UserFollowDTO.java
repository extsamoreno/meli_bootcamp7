package com.example.desafiospring.socialmeli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFollowDTO {
    int userId;
    String userName;
}
