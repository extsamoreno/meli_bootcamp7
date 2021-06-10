package com.example.desafio_1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FollowedPostDTO {
    private int userId;
    private List<PostPromoDTO> posts;
}
