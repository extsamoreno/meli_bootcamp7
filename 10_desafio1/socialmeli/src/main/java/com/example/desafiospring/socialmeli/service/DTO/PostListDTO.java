package com.example.desafiospring.socialmeli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class PostListDTO {
    int userId;
    List<PostDTO> post;
}
