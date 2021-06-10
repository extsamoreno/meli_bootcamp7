package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private int userId;
    private String userName;
    private ArrayList<ProductBaseResponseDTO> posts;
}
