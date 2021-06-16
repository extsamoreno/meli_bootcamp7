package com.meli.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    private Integer id;
    private String name;
    private Double price;
}
