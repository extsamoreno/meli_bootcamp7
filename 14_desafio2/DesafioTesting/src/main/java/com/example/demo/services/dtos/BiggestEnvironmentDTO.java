package com.example.demo.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiggestEnvironmentDTO {

    private String environment_name;
    private double square_meters;

}
