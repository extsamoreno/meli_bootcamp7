package com.Desafio1.SocialMeli.DTOS;

import com.Desafio1.SocialMeli.Models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPostListDTO {
    private int userId;
    private List<Post> postList = new ArrayList<>();
}
