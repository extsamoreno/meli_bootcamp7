package com.meli.spring_day_2.Dto;

import com.meli.spring_day_2.Clases.Habitacion;

import java.util.HashMap;

public class CasaDto {
    private String nombre;
    private float metrosCuadrados;
    private float preciocasa;
    private Habitacion habitacionGrande;
    private HashMap<Habitacion,Float> mtrsHabitaciones;

    public CasaDto() {
        this.mtrsHabitaciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(float metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public float getPreciocasa() {
        return preciocasa;
    }

    public void setPreciocasa(float preciocasa) {
        this.preciocasa = preciocasa;
    }

    public Habitacion getHabitacionGrande() {
        return habitacionGrande;
    }

    public void setHabitacionGrande(Habitacion habitacionGrande) {
        this.habitacionGrande = habitacionGrande;
    }

    public HashMap<Habitacion, Float> getMtrsHabitaciones() {
        return mtrsHabitaciones;
    }

    public void setMtrsHabitaciones(HashMap<Habitacion, Float> mtrsHabitaciones) {
        this.mtrsHabitaciones = mtrsHabitaciones;
    }
}
