package com.meli.claseSpring2.web.dto;

import lombok.*;



@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class HabitacionDTO {
    private String nombre;
    private double ancho;
    private double largo;
}