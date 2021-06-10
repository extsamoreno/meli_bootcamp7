package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsConstructorDTO extends UserDTO {
    private List<PostDTO> posts;

    public PostsConstructorDTO(int userId, String userName, List<PostDTO> posts){

        super(userId, userName);
        this.posts = posts;

    }
}
