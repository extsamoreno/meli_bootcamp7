package com.example.socialmeli.dtos.post;

import com.example.socialmeli.models.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostListDTO {
    Integer userId;
    String userName;
    List<Post> posts;
}
