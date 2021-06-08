package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFollowDTO {
    int userId;
    String userName;
}
