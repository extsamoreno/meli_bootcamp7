package com.meli.socialmeli.dto;

import com.meli.socialmeli.model.Product;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostDTO {
    private Integer userId;
    private Integer id_post;
    private Date date;
    private Product detail;
    private Integer category;
    private double price;
}
