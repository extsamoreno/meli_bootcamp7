package com.desafiospring.socialMeli.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PromoPostListDTO {
    private int userId;
    private String userName;
    private List<PostDTO> promoList;
}
