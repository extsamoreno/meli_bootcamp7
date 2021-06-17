package com.meli.desafio2.web.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquareMetersEnvironmentResponse {
    private String prop_name;
    private HashMap<String,Double> Environment_square_meters;
}
