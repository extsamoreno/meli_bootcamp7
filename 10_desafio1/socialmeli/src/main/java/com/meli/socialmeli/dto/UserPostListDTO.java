package com.meli.socialmeli.dto;

import com.meli.socialmeli.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostListDTO {
    int userId;
    List<Post> posts;
}
