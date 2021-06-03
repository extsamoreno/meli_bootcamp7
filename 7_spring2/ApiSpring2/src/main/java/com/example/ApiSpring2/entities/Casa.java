package com.example.ApiSpring2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Casa {
    private Integer id;
    private String nombre, direccion;
    private Habitacion[] habitaciones;
}
