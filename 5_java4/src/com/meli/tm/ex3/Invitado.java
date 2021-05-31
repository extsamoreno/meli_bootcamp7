package com.meli.tm.ex3;

public abstract class Invitado {
    private String nombre;

    public Invitado(String nombre) {
        this.nombre = nombre;
    }

    public abstract void comer();

    public void gritar(String mensaje) {
        System.out.println('¡' + mensaje + '!');
    }
}
