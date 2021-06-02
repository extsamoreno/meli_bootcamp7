package com.example.ApiSpring2.entities;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class Habitacion {
    private String nombre;
    private int ancho, largo;

    public Integer devolverMetrosTotales(){
        return ancho*largo;
    }
}
