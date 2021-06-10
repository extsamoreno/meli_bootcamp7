package com.example.socialmeli.models.dtos.response;

import com.example.socialmeli.models.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ListFollowedResponseDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followed;
}