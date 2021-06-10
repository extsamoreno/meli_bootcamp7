package com.meli.socialmeli.dto.user;

import com.meli.socialmeli.dto.post.PostDTO;

import java.util.List;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromoPostsDTO {
    private Integer userId;
    private String userName;
    private List<PostDTO> posts;
}
