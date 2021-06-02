package com.meli.claseSpring2.web.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaResponse {
    private String nombre;
    private String mensaje;
    private double promedio;
}
