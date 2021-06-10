package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.PublicationPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationPromoListDTO {
    private int userId;
    private String userName;
    private List<PublicationPromoDTO> posts;
}
