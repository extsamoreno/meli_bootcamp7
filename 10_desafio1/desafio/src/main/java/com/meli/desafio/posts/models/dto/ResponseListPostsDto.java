package com.meli.desafio.posts.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseListPostsDto {
    private Integer userId;
    private List<PostDTO> posts;
}
