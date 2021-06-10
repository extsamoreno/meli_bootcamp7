package com.reto1.demo.Model.DTO.PostObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastPostDTO {
    int userId;
    List<PostDTO> posts;
}
