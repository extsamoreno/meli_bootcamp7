package com.bootcamp.socialmeli.DTO;

import com.bootcamp.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {
    private int userId;
    private int postId;
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private double price;
}
