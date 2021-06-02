package com.meli.claseSpring2.web.dto;

import lombok.*;

import java.util.ArrayList;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class CasaDTO {
    private String nombre;
    private String direccion;
    private ArrayList<HabitacionDTO> listaHabitaciones = new ArrayList<>();


}

