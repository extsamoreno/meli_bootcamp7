package com.meli.socialmeli.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public Integer product_id;
    public String productName;
    public String type;
    public String brand;
    public String color;
    public String notes;
}
