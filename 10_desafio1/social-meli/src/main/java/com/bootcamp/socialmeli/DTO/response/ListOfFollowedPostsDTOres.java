package com.bootcamp.socialmeli.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOfFollowedPostsDTOres {
    private Integer userId;
    private List<FollowedPostDTOres> posts;
}
