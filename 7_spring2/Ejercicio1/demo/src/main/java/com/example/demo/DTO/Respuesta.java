package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Data
public class Respuesta {

    private double metrosTotales;
    private double valorCasa;
    private Habitacion habitacionMasGrande;
    private List<Habitacion> habitacionConMetrosCuadrados;


}
