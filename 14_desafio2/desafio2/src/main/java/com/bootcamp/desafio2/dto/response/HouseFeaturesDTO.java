package com.bootcamp.desafio2.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseFeaturesDTO {

    private String prop_name;
    private double total_area;
    private double price;
    private EnvironmentShortDTO biggest_environment;
}
