package com.example.socialmeli.dtos;

import com.example.socialmeli.models.Post;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListDTO {
    Integer userId;
    List<Post> posts;
}
