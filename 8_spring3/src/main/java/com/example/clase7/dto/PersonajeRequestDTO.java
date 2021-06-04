package com.example.clase7.dto;

public class PersonajeRequestDTO {
    private String nombre;

    public PersonajeRequestDTO() {
    }

    public PersonajeRequestDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
