package com.bootcamp.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowedPostDTO {
    private Integer userId;
    private List<PostFollowedDTO> posts;
}
