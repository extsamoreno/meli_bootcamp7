package com.example.demo.demo;

import lombok.*;

@Data //get, set
@AllArgsConstructor //constructor automatico
@NoArgsConstructor //constructor vacio
public class CasaDTO {
    private Casa casa;
    private double metrosTotales;
    private double precio;

}
