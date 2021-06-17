package com.bootcamp.tucasitatasaciones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    private String name;
    private Double width;
    private Double length;
}
