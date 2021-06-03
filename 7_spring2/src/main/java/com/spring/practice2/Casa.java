package com.spring.practice2;

import java.util.ArrayList;

public class Casa {
    private String nombre, direccion;
    private ArrayList<Habitacion> habitaciones;

    public Casa (String nombre, String direccion, ArrayList<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = habitaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
