package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostFollowingDTO {

    private int userId;
    private List<PostDTO> postList;
}
