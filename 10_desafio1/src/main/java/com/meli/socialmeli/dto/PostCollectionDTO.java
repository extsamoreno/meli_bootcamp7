package com.meli.socialmeli.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostCollectionDTO {

    private int userId;
    private List<PostDTO> posts;

}
