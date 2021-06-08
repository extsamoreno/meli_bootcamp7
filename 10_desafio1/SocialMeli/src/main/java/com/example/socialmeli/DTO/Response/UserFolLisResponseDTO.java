package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserFolLisResponseDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followed;
}
