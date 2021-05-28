package com.company;

public class Persona implements Precedable<Persona>{
    private String nombre;
    private int dni;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public Persona(){}

    public Persona(String nombre, int dni, int edad){
        this.nombre =nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int precedeA(Persona persona) {
        if(this.edad > persona.getEdad()){
            return 1;
        }else{
            return 0;
        }
    }
}
