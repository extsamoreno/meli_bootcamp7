package com.example.socialmeli.dtos;

import com.example.socialmeli.models.User;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersListDTO {
    private Integer id;
    private String name;
    List<User> followers;
}
