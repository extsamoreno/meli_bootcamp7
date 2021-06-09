package com.example.desafio1.dtos;

import com.example.desafio1.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePromoListDTO {
    private int userId;
    private String userName;
    private List<Post> posts;
}
