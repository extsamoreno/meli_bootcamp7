package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {

    private String nombre;
    private String direccion;
    private ArrayList<Habitacion> habitaciones;
}
