package com.meli.socialmeli.service.dto;

import com.meli.socialmeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTOAllPostList {
    private int userId;
    private String userName;
    private List<Post> posts;
}
