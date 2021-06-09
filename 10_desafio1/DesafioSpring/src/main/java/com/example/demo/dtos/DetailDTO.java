package com.example.demo.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO {

    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
