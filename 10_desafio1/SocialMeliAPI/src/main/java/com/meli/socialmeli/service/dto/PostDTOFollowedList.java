package com.meli.socialmeli.service.dto;

import com.meli.socialmeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTOFollowedList {
    private int userId;
    private List<Post> posts;
}
