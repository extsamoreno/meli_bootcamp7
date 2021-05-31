package com.bootcamp;

public class Invitado {

    String nombre;

    public Invitado() {

    }

    public Invitado(String nombre) {
        this.nombre = nombre;
    }

    public void comerTorta() {
        System.out.println(this.nombre + ": que buena torta");
    }

}
