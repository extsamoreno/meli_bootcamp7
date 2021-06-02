package spring2.demo.models;

public class M2PorHabitacion {
    String nombre;
    int m2;

    public M2PorHabitacion(String nombre, int m2) {
        this.nombre = nombre;
        this.m2 = m2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }
}
