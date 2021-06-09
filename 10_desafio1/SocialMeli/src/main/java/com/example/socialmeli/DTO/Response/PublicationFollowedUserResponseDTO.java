package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.PublicationDTO;
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
public class PublicationFollowedUserResponseDTO {
    UserDTO user;
    List<PublicationDTO> posts;
}
