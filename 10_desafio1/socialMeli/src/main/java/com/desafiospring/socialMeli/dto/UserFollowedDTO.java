package com.desafiospring.socialMeli.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowedDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followers;

}
