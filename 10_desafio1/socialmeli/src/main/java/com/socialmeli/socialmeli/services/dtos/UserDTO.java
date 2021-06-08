package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    int userId;
    String userName;
    int followers_count;
}
