package com.desafiospring.socialMeli.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PromoPostDto extends NewPostDTO {
    private boolean hasPromo;
    private double discount;
}
