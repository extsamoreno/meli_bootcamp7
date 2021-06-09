package com.api.socialmeli.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class CountPromoDTO {
    private int userId;
    private String userName;
    private int promoProducts_count;
}
