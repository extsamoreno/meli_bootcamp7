package com.meli.metrocuadrado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    private String nombre;
    private double ancho,largo;

    public double calcularMetrosCuadrados(){
        return ancho*largo;
    }

    public HabitacionDTO crearHabitacionConMetros(){
        return new HabitacionDTO(nombre,calcularMetrosCuadrados());
    }
}
