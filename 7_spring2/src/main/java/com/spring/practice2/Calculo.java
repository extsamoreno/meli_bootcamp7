package com.spring.practice2;

import java.util.ArrayList;

public class Calculo {
    public static double  metrosCuadrados (Casa casa) {
        double metrosTotales = 0;
        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            metrosTotales += casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo();
        }
        return metrosTotales;
    }

    public static HabitacionDTO habitacionMasGrande (Casa casa) {
        double metrosMax = 0;
        HabitacionDTO habitacionDTO = new HabitacionDTO ();
        for (int i = 0; i < casa.getHabitaciones().size(); i++) {
            double metrosTotales = casa.getHabitaciones().get(i).getAncho() * casa.getHabitaciones().get(i).getLargo();
            if (metrosTotales > metrosMax) {
                metrosMax = metrosTotales;
                habitacionDTO.setNombre(casa.getHabitaciones().get(i).getNombre());
                habitacionDTO.setMetrosCuadrados(metrosMax);
            }
        }
        return habitacionDTO;
    }

}
