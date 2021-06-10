package com.api.socialmeli.dto;

import lombok.*;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserFolowedDTO {
    private int userId;
    private String userName;
    private ArrayList<UserDTO> followed;
}

