package com.SocialMeli.dtos;

import com.SocialMeli.models.User;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Vendedores Seguidos

public class FollowedUserDTO {
    private Integer userID;
    private String userName;
    private List<User> followed;
}
