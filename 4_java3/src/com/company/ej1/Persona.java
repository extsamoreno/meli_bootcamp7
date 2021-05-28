package com.company.ej1;

public class Persona implements Precedable<Persona> {

    private String name;
    private int dni;

    public Persona() {
        this.name = "";
        this.dni = 0;
    }

    public Persona(String name, int dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public int precedeA(Persona t) {
        return dni - t.dni;
    }

    @Override
    public String toString() {
        return dni + " " + name;
    }

}
