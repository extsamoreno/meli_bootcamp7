package spring2.demo.models;

public class Habitacion {
    private String nombre = null;
    private int ancho = 0;
    private int largo = 0;

    public int getM2(){
        return ancho * largo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
}
