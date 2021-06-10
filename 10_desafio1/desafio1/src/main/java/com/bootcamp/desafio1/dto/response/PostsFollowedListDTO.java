package com.bootcamp.desafio1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class PostsFollowedListDTO {

    private int userId;
    private ArrayList<PostDTO> posts;
}
