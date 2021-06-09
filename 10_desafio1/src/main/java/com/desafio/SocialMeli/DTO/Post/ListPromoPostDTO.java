package com.desafio.SocialMeli.DTO.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPromoPostDTO {
    private int userId;
    private String userName;
    private List<PromoPostDTO> posts;
}
