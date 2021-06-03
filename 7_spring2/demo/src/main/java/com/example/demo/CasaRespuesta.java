package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
@AllArgsConstructor
public class CasaRespuesta {
    private double metrosCuadTotales; //Metros cuadrados totales de la casa
    private double precio; //Precio de la casa segun criterio 800USD x metro cuadrado
    private Habitacion habGrande; //Habitacion mas grande de la casa
    private HashMap<String, Double> hm;

    public CasaRespuesta(){
        this.hm = new HashMap<>();
    }
}