package com.desafiospring.socialMeli.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
