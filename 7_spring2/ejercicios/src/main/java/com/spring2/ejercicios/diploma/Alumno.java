package com.spring2.ejercicios.diploma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class Alumno {

    private String nombre;
    private HashMap<String, Double> materias;

    public Alumno() {
        this.materias = new HashMap<>();
    }

/*
    public Alumno(Alumno datos) {
        this.nombre = datos.getNombre();
        this.materias = new HashMap<>();
        //HashMap<String, Double> scan = datos.getMaterias();
        for(Map.Entry<String,Double> entry : materias.entrySet()) {
            this.materias.put(entry.getKey(), entry.getValue());
        }
    }

     */

    public double promedio(){
        double suma = 0.0;
        for(Map.Entry<String,Double> entry : materias.entrySet()) {
            Double value = entry.getValue();
            suma += value;
        }
        double promedio = suma / materias.size();
        return promedio;
    }

    public String promedioAlto(){
        if (promedio() >= 9){
            return "Buena esa chino!!!!";
        }
        return "";
    }
}
