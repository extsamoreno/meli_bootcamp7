package com.meli.claseSpring2.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecioDTO {
    private double tamano;
    private double precio;
}
