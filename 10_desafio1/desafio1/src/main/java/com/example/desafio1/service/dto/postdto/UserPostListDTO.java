package com.example.desafio1.service.dto.postdto;

import com.example.desafio1.model.ProductPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPostListDTO {
    private int userId;
    private ArrayList<ProductPost> posts;
}
