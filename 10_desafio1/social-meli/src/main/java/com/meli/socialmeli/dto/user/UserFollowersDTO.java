package com.meli.socialmeli.dto.user;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> followers;
}
