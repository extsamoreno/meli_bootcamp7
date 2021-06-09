package com.meli.socialmeli.dto;

import com.meli.socialmeli.model.Post;

import java.util.List;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromoPostsDTO {
    private Integer userId;
    private String userName;
    private List<Post> posts;
}
