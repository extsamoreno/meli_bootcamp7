package com.example.clase7.dto;

public class PlatoResponseDTO {
    private String nombre;
    private int caloriasTotales;

    public PlatoResponseDTO() {
    }

    public PlatoResponseDTO(String nombre, int caloriasTotales) {
        this.nombre = nombre;
        this.caloriasTotales = caloriasTotales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(int caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }
}
