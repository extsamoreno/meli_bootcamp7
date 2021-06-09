package com.example.socialmeli.models.dtos.response;

import com.example.socialmeli.models.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ListSellerPromoProductsDTO {
    private int userId;
    private String userName;
    private ArrayList<PostDTO> posts;
}
