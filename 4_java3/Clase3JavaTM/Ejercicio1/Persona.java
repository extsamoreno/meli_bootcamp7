package com.company.Clase3JavaTM.Ejercicio1;

public class Persona implements Precedable<Persona>{
    private String nombre;
    private int dni;

    public Persona() {
    }

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
    public int precedeA(Persona persona) {
        if(this.dni>persona.dni){
            return 1;
        }else if(this.dni>persona.dni){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
