package com.SocialMeli.dtos;

import com.SocialMeli.models.User;
import lombok.*;
import java.util.List;

import lombok.Data;

@Data
public class FollowedListDTO {
    int userId;
    String userName;
    UserDTO[] followed;
}
