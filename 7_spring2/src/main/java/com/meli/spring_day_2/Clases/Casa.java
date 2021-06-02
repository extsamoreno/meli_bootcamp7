package com.meli.spring_day_2.Clases;

import java.util.List;

public class Casa {
    private String nombre;
    private String direccion;
    private List<Habitacion> habitacionList;

    public Casa() {
    }

    public Casa(String nombre, String direccion, List<Habitacion> habitacionList) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitacionList = habitacionList;
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

    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }
}
