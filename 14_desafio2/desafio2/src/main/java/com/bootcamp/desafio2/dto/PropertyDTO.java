package com.bootcamp.desafio2.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {

    private String prop_name;
    private double total_area;
    private double price;
    //private EnvironmentDTO biggest_environment;
}
