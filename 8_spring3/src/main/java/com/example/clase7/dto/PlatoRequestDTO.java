package com.example.clase7.dto;

import java.util.ArrayList;

public class PlatoRequestDTO {
    private String nombre;
    private ArrayList<IngredienteRequestDTO> ingredientes;

    public PlatoRequestDTO() {
    }

    public PlatoRequestDTO(String nombre, ArrayList<IngredienteRequestDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<IngredienteRequestDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteRequestDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
