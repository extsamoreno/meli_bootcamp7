package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationCreateResponseDTO {
    private PublicationDTO post;
}
