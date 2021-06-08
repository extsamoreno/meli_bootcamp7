package com.socialMeli.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowListDTO {

    private Integer userId;
    private String username;
    private ArrayList<UserDTO> followList;
}
