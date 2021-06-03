package com.example.demo.demo;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {
    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();


}
