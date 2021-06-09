package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PostListDTO {

    private Integer userId;
    private List<PostDTO> listPost;

    public PostListDTO(){
        listPost = new ArrayList<>();
    }

}
