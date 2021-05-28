package com.company;

public class Persona implements Precedable<Persona>{
    //Propiedades
    private String nombre;
    private int dni;

    //Getters y setters
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

    //Constructor
    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona persona) {
        int personaDni = persona.getDni();

        if(this.dni > personaDni) return 1; //Es mayor el nuestro
        if(this.dni < personaDni) return -1; //Es menor el nuestro

        return 0; //Si no es mayor y no es menor, es igual
    }

    @Override
    public String toString() {
        return  "{ nombre : '" + this.nombre + "', dni : '" + this.dni + "' }";
    }
}
