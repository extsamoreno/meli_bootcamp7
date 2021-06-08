package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserFolsLisResponseDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followers;
}
