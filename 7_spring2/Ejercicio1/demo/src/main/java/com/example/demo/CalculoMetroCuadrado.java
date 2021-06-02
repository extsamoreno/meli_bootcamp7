package com.example.demo;

import com.example.demo.DTO.Casa;
import com.example.demo.DTO.Habitacion;
import com.example.demo.DTO.Respuesta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CalculoMetroCuadrado {

    private final static double VALOR_METRO_CUADRADO = 800.0;

    public static Respuesta calcularCasa(Casa casa){
        Respuesta respuesta = new Respuesta();

        respuesta.setMetrosTotales(calcularMetrosCuadradosCasa(casa).getMetrosTotales());
        respuesta.setValorCasa(respuesta.getMetrosTotales());
        respuesta.setHabitacionConMetrosCuadrados(metroCuadradoCadaHabitacion(casa).getHabitacionConMetrosCuadrados());
        respuesta.setHabitacionMasGrande(habitacionMasGrande(casa).getHabitacionMasGrande());

        return respuesta;
    }

    public static Respuesta calcularMetrosCuadradosCasa(Casa casa){
        double metrosCuadrados = 0.0;
        for (Habitacion habitacion: casa.getListaHabitaciones()) {
            metrosCuadrados += habitacion.getAncho() * habitacion.getLargo();
        }

        Respuesta respuesta = new Respuesta();
        respuesta.setMetrosTotales(metrosCuadrados);
        return respuesta ;
    }

    public static Respuesta calcularValorCasa(Casa casa){
        Respuesta respuesta = new Respuesta();
        respuesta.setValorCasa(calcularMetrosCuadradosCasa(casa).getMetrosTotales()*VALOR_METRO_CUADRADO);
        return respuesta;
    }

    public static Respuesta habitacionMasGrande(Casa casa){

        casa.setListaHabitaciones(metroCuadradoCadaHabitacion(casa).getHabitacionConMetrosCuadrados());

        Habitacion habitacionMasGrande = null;
        double contador = 0.0;

        for (Habitacion habitacion: casa.getListaHabitaciones()) {
            if(habitacion.getMetrosCuadrados() >contador){
                contador = habitacion.getMetrosCuadrados();
                habitacionMasGrande = habitacion;
            }
        }
        Respuesta respuesta = new Respuesta();
        respuesta.setHabitacionMasGrande(habitacionMasGrande);
        return respuesta;
    }

    public static Respuesta metroCuadradoCadaHabitacion(Casa casa){
        for (Habitacion habitacion: casa.getListaHabitaciones()) {
            habitacion.setMetrosCuadrados(habitacion.getAncho() * habitacion.getLargo());
        }

        Respuesta respuesta = new Respuesta();
        respuesta.setHabitacionConMetrosCuadrados(casa.getListaHabitaciones());
        return respuesta;
    }

}
