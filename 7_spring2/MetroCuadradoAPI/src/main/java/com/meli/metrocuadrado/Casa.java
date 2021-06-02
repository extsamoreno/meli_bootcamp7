package com.meli.metrocuadrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class Casa {
    private String nombre, direccion;
    private ArrayList<Habitacion> listaHabitaciones= new ArrayList<>();
    @JsonIgnore
    private double metrosTotales;

    public double metrosCuadradosTotales(){
        return listaHabitaciones.stream()
                .mapToDouble(habitacion -> habitacion.calcularMetrosCuadrados())
                .sum();
    }

    public double valorCasa(){
        return metrosCuadradosTotales()*800;
    }

    public Habitacion habitacionMasGrande(){
        double max=0;
        Habitacion maxH=new Habitacion();
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            if (listaHabitaciones.get(i).calcularMetrosCuadrados()>max) {
                max= listaHabitaciones.get(i).calcularMetrosCuadrados();
                maxH = listaHabitaciones.get(i);
            }
        }
        return maxH;
    }

    public List<HabitacionDTO> habitacionesConMetros(){
        List<HabitacionDTO> list= new ArrayList<>();
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            list.add(listaHabitaciones.get(i).crearHabitacionConMetros());
        }
        return list;
    }
}
