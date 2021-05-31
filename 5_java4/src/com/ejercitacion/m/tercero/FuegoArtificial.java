package com.ejercitacion.m.tercero;

public class FuegoArtificial {

    public String nombre;

    public FuegoArtificial(String nombre) {
        this.nombre = nombre;
    }

    public FuegoArtificial() {
    }

    public void explotar() {
        System.out.println("BOOOM!!");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
