package com.bootcamp.desafio2.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentShortDTO {

    private String environment_name;
    private double environment_area;

}
