package com.company;

public class Persona implements Precedable<Persona> {

    private String name;
    private int dni;

    public Persona() {
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
    public int precedeA(Persona persona) {
        return this.dni - persona.getDni();
        //para ordenar string usar compareTo
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + name + '\'' +
                ", dni=" + dni +
                '}';
    }
}
