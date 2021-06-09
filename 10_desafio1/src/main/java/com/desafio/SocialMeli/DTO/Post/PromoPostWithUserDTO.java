package com.desafio.SocialMeli.DTO.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostWithUserDTO extends PostWithUserDTO {
    private boolean hasPromo;
    private double discount;

}
