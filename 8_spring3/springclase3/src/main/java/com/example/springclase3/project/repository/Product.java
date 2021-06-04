package com.example.springclase3.project.repository;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String barCode;
    private Integer stock;
}
