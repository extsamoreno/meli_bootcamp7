package com.meli.socialmeli.dto.post;

import java.util.List;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedPostsDTO {
    private Integer userId;
    private List<PostDTO> posts;
}
