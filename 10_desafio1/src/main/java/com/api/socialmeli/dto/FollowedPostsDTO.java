package com.api.socialmeli.dto;

import com.api.socialmeli.model.PostModel;
import lombok.*;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FollowedPostsDTO {
    private int userId;
    private List<PostModel> posts;
}
