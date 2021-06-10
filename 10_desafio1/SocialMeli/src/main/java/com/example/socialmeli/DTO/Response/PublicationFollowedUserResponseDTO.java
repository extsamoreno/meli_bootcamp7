package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.PublicationDTO;
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
    private int userId;
    private List<PublicationDTO> posts;
}
