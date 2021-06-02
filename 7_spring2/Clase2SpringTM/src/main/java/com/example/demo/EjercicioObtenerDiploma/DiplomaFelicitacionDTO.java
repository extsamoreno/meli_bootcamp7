package com.example.demo.EjercicioObtenerDiploma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaFelicitacionDTO extends DiplomaDTO{
    private String mensaje = "Felicitaciones, venite a meli :) ";

}
