package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CasaRespuesta {
    private double metrosCuadradosTotales;
    private double valorCasa;
    private Habitacion habGrande;
    // Nombre, m2
    private HashMap<String, Double> hm;

    public HashMap<String, Double> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, Double> hm) {
        this.hm = hm;
    }

 }
