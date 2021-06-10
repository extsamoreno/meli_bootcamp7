package com.bootcamp.socialmeli.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOfPostsWithUsernameDTOres extends ListOfPostsDTOres {
    private String username;
}
