package com.socialmedia.socialmedia.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;
}
