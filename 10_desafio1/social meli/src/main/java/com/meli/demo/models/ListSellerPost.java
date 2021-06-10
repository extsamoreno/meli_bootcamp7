package com.meli.demo.models;

import com.meli.demo.dtos.PostResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data@AllArgsConstructor@NoArgsConstructor
public class ListSellerPost {
    private int userId;
    private ArrayList<PostResponseDTO> posts;
}
