package com.example.demo.Services.DTO;

import com.example.demo.Entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetPostsFollowedDTO {

    private int userId;
    private List<PostDTO> posts;
}
