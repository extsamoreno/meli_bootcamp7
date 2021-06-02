package com.example.demo.EjercicioCalculadoraMetrosCuadrados;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Casa {

    private String nombre;
    private String direccionC;
    private ArrayList<Habitacion> habitaciones;

}
