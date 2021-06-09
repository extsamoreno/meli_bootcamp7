package com.springChallenge.api.controller.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PostsListDTO {
    int userId;
    PostDTO[] posts;
}
