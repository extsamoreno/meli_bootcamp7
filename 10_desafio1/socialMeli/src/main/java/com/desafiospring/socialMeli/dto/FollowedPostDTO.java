package com.desafiospring.socialMeli.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostDTO {

    private int userId;
    private List<PostDTO> posts;

}
