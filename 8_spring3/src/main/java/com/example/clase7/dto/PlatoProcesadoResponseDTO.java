package com.example.clase7.dto;

import java.util.ArrayList;

public class PlatoProcesadoResponseDTO {
    private String nombre;
    private ArrayList<IngredienteResponseDTO> ingredientes;
    private IngredienteResponseDTO ingredienteConMasCalorias;
    private int caloriasTotales;

    public PlatoProcesadoResponseDTO() {
    }

    public PlatoProcesadoResponseDTO(String nombre, ArrayList<IngredienteResponseDTO> ingredientes, IngredienteResponseDTO ingredienteConMasCalorias, int caloriasTotales) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
        this.caloriasTotales = caloriasTotales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<IngredienteResponseDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteResponseDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(int caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }

    public IngredienteResponseDTO getIngredienteConMasCalorias() {
        return ingredienteConMasCalorias;
    }

    public void setIngredienteConMasCalorias(IngredienteResponseDTO ingredienteConMasCalorias) {
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }
}
