package com.meli.desafio2.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquareMetersEnvironmentResponse {
    private String prop_name;
    private HashMap<String,Double> Environment_square_meters;
}
