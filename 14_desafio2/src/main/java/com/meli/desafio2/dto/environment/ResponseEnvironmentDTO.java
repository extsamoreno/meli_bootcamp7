package com.meli.desafio2.dto.environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEnvironmentDTO {

    private String name;
    private Double width;
    private Double length;
    private Double envArea;
}
