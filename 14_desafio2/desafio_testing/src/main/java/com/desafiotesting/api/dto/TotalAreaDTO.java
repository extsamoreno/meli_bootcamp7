package com.desafiotesting.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class TotalAreaDTO {
    private String name;
    private Double totalArea;
}
