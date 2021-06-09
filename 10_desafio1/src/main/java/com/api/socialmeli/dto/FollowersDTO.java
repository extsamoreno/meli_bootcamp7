package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowersDTO {
    private int userId;
    private String userName;
    private ArrayList<UserDTO> followers;
}
