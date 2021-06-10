package com.example.Challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductListPromoDTO {
    private Integer userId;
    private String userName;
    private List<ProductDTO> posts;
}
