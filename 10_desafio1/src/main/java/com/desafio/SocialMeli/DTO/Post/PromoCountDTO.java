package com.desafio.SocialMeli.DTO.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCountDTO {
    private int userId;
    private String userName;
    private int promoproducts_count;
}
