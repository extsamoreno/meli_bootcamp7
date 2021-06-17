package com.desafiotesting.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class EnvironmentAreaDTO {
    private String name;
    private double area;
}
