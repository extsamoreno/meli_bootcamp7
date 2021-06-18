package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiggestPropResponseDTO {
    private String prop_name;
    private BiggestEnvironmentDTO biggestEnvironment;
}
