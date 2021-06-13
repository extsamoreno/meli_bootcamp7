package com.desafio.socialMeli.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
