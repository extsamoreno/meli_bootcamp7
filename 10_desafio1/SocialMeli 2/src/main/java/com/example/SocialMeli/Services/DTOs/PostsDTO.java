package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class PostsDTO extends UserDTO{

    private List<PostDTO> posts;

    public PostsDTO(int userId, String userName, List<PostDTO> posts){

        super(userId, userName);
        this.posts = posts;

    }

}
