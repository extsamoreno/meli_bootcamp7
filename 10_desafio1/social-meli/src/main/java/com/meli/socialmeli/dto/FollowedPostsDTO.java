package com.meli.socialmeli.dto;

import com.meli.socialmeli.model.Post;

import java.util.List;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostsDTO {
    private Integer userId;
    private List<Post> posts;
}
