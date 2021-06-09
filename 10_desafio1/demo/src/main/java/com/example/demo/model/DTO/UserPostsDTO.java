package com.example.demo.model.DTO;

import com.example.demo.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class UserPostsDTO {

    private int userId;
    private ArrayList<Post> posts;
}
