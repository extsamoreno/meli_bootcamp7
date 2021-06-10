package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWithPromListResponseDTO {
    private int userId;
    private String userName;
    private List<PostWithPromDTO> posts;
}
