package com.meli3;

public class Invitados {
    private String nombre;
    private boolean esMeli;

    public Invitados(String nombre, boolean esMeli) {
        this.nombre = nombre;
        this.esMeli = esMeli;
    }

    public void comerPastel(){
        if(this.esMeli){
            System.out.println(this.nombre + " dice: Viva la Chiqui!!!");
        } else {
            System.out.println(this.nombre + " esta Comiendo :D");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsMeli() {
        return esMeli;
    }

    public void setEsMeli(boolean esMeli) {
        this.esMeli = esMeli;
    }
}
