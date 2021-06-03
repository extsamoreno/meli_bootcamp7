package com.example.demo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Casa {
    //@JsonProperty("nombreEnJSON")
    private String nombre;
    private String direccion;
    private List<Habitacion> listHabitaciones;

    public Casa(){
        this.listHabitaciones = new ArrayList<>();
    }
}