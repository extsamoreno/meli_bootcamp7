package com.example.socialmeli.DTO.Response;

import com.example.socialmeli.DTO.PublicationPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPromoCreateResponseDTO {
    private PublicationPromoDTO publication;
}
