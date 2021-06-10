package com.example.socialmeli.dtos.user;

import com.example.socialmeli.dtos.user.UserDTO;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersListDTO {
    private Integer id;
    private String name;
    List<UserDTO> followers;
}
