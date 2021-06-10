package com.example.demo.dtos;

import com.example.demo.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPostListResponseDTO {
    private int userId;
    private List<PostDTO> posts=new ArrayList<>();
}
