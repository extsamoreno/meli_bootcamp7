package com.company;

public class Fuego implements Explosivo<Fuego> {
    private String sonido;

    public Fuego(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public void explotar() {
        System.out.println(sonido);
    }

}
