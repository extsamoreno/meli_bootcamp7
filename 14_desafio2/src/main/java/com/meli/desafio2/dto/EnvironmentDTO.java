package com.meli.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentDTO {

    private String name;

    private Double width;

    private Double length;
}
