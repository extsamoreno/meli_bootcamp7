package com.socialmeli.desafio.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailModel {

    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;



}
