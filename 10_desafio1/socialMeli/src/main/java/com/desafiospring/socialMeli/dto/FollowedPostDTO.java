package com.desafiospring.socialMeli.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostDTO {

    private int userId;
    private List<PostDTO> posts;

}
