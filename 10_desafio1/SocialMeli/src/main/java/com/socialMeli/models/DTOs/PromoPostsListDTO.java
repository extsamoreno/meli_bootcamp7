package com.socialMeli.models.DTOs;

import com.socialMeli.models.Post;
import com.socialMeli.models.PromoPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostsListDTO {

    private int userId;
    private String username;
    List<Post> posts;
}
