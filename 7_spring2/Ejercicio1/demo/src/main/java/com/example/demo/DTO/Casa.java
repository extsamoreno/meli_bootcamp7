package com.example.demo.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {

    private String nombre;
    private String direccion;
    private List<Habitacion> listaHabitaciones;

}
