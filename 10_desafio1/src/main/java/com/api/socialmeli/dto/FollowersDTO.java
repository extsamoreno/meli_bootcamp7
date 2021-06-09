package com.api.socialmeli.dto;

import lombok.*;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowersDTO {
    private int userId;
    private String userName;
    private ArrayList<UserDTO> followers;
}
