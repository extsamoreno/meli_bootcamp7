package com.example.socialmeli.dtos;

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
