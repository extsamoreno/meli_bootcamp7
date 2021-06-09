package com.socialMeli.models.DTOs;

import com.socialMeli.models.Post;
import com.socialMeli.models.StandardPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsDTO {

    private int userId;
    private ArrayList<Post> posts;
}
