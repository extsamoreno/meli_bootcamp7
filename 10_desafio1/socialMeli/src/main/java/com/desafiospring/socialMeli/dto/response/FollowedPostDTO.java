package com.desafiospring.socialMeli.dto.response;

import com.desafiospring.socialMeli.dto.PostDTO;
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
