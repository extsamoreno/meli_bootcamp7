package com.meli.socialmeli.dto.product;

import com.meli.socialmeli.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {
    private Integer userId;
    private Integer id_post;
    private String date;
    private Product detail;
    private Integer category;
    private double price;
}
