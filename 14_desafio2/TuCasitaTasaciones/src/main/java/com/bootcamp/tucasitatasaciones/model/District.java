package com.bootcamp.tucasitatasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
    private Long id;
    private String name;
    private Double price;
}
