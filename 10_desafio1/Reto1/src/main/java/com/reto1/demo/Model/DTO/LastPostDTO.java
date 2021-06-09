package com.reto1.demo.Model.DTO;

import com.reto1.demo.Model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastPostDTO {
    int userId;
    List<PostDTO> posts;
}
