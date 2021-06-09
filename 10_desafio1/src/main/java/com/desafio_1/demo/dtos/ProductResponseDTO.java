package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private LocalDate date;
    private ProductDetailDTO detail;
    private double price;
}
