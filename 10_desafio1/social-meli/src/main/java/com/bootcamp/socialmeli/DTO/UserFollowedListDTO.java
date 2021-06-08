package com.bootcamp.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowedListDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> followed;
}
