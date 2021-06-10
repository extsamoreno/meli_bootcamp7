package com.desafiospring.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class NewPromoPostDTO extends NewPostDTO {
    private boolean hasPromo;
    private double discount;

}
