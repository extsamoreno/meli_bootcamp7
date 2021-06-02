package com.example.ApiSpring2.dtos;

import com.example.ApiSpring2.entities.Casa;
import com.example.ApiSpring2.entities.Habitacion;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class CasaDTO {
    private String nombre, direccion;
    private Habitacion[] habitaciones;
    public CasaDTO(Casa casa){
        nombre = casa.getNombre();
        direccion = casa.getDireccion();
        habitaciones = casa.getHabitaciones();
    }
}
