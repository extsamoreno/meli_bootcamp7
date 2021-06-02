package com.calculadora;

import com.models.Casa;
import com.models.Habitacion;
import com.models.ResponseCasaDTO;
import com.models.ResponseHabitacionDTO;

import java.util.ArrayList;

public class HouseService {

    private static int precioHabitacionDolares = 800;

    public static ResponseCasaDTO calcularMetrosTotales(Casa casa){

        double[] resultado = new double[1];

        casa.getHabitaciones().stream().forEach(habitacion -> {
            resultado[0] += calcularMetros(habitacion);
        });

        return (new ResponseCasaDTO(casa, resultado[0]));
    }

    public static double calcularMetros(Habitacion habitacion) {
        return (habitacion.getAncho()*habitacion.getLargo());
    }

    public static ResponseCasaDTO calcularValor(Casa casa){
        double[] resultado = new double[1];

        casa.getHabitaciones().stream().forEach(habitacion -> {
            resultado[0] += calcularMetros(habitacion)*precioHabitacionDolares;
        });

        return new ResponseCasaDTO(casa, resultado[0]);
    }

    public static Habitacion habitacionMasGrande (Casa casa) {

        Habitacion habitacionMasGrande = new Habitacion();
        double m2 = 0;

        for (Habitacion habitacion: casa.getHabitaciones()) {
            if (calcularMetros(habitacion) > m2){
                m2 = calcularMetros(habitacion);
                habitacionMasGrande = habitacion;
            }
        }
        return habitacionMasGrande;
    }

    public static ResponseHabitacionDTO calcularM2Habitacion (Casa casa){
        ArrayList<Double> m2Habitaciones = new ArrayList<>();

        for (Habitacion habitacion: casa.getHabitaciones())
            m2Habitaciones.add(calcularMetros(habitacion));

        return new ResponseHabitacionDTO(casa, m2Habitaciones);
    }
}
