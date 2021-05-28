package com.ejercicios;

public class Persona implements Precedable<Persona>{
    private String nombre;
    private long dni;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Persona(String nombre, long dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona persona) {
        if(this.dni > persona.dni)
            return 1;

        return 0;
    }
}
