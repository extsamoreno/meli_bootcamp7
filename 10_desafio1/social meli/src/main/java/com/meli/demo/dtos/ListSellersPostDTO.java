package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data@AllArgsConstructor@NoArgsConstructor
public class ListSellersPostDTO {
    private int userId;
    private ArrayList<PostResponseDTO> posts;
}
