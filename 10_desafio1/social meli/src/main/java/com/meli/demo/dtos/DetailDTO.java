package com.meli.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class DetailDTO {

    private  Integer product_id;
    private  String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
