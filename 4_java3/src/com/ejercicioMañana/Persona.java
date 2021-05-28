package com.ejercicioMañana;

public class Persona implements Precedable<Persona>{
    String nombre;
    int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Dni: " + this.dni;
    }

    @Override
    public int precedeA(Persona persona) {
        return this.dni - persona.dni;
    }
}
