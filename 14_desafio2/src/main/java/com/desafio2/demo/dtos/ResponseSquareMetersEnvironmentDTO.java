package com.desafio2.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSquareMetersEnvironmentDTO {
    private String propertyName;
    private List<ResponseEnvironmentDTO> environments;
}
