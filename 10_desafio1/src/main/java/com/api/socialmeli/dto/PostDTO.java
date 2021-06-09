package com.api.socialmeli.dto;

import com.api.socialmeli.model.ProductModel;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PostDTO {
    private int userId;
    private int id_post;
    private LocalDate date;
    private ProductModel detail;
    private int category;
    private double price;
}
