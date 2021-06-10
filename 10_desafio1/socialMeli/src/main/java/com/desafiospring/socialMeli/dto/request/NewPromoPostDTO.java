package com.desafiospring.socialMeli.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class NewPromoPostDTO extends NewPostDTO {
    private boolean hasPromo;
    private double discount;

}
