package com.meli.desafio.posts.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostPromoListDTO {
    private Integer userId;
    private String userName;
    private List<PostPromoDTO> posts;
}
