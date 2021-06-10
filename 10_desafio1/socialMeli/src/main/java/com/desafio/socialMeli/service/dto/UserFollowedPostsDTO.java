package com.desafio.socialMeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class UserFollowedPostsDTO{ //extends UserDTO {
    private List<PostDTO> posts;

    public UserFollowedPostsDTO() {
        //super();
        this.posts = new ArrayList<PostDTO>();
    }

}
