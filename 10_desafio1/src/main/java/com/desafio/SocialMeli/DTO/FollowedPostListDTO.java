package com.desafio.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPostListDTO {
    private int userId;
    private List<PostDTO> posts;
}
