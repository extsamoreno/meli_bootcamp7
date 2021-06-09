package com.desafiospring.socialMeli.dto;

import com.desafiospring.socialMeli.model.Post;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostDTO {

    private int userId;
    private List<Post> postList;

}
