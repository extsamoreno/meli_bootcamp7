package com.meli.socialmeli.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private int userId;
    private String username;
    private List<UserDTO> followedBy, followers;
}
