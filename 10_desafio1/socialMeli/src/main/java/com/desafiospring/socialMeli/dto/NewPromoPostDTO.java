package com.desafiospring.socialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewPromoPostDTO extends NewPostDTO {
    private boolean hasPromo;
    private double discount;

}
