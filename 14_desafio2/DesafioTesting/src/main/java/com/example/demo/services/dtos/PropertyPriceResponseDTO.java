package com.example.demo.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPriceResponseDTO {
    private String prop_name;
    private double prop_price;
    private List<EnvironmentDTO> enviroments;
}
