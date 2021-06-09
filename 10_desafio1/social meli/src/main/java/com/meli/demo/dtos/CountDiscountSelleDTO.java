package com.meli.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class CountDiscountSelleDTO {

    private int userId;
    private String userName;
    private int promoproducts_count;
}
