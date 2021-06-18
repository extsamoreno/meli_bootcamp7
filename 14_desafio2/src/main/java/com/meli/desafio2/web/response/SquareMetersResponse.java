package com.meli.desafio2.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquareMetersResponse {
    private String property_name;
    private double square_meters;
}
