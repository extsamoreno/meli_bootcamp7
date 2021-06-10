package com.spring.desafioSpring.DTOs;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
