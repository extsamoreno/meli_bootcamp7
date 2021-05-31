package com.meli;

public class SocorristaMoto {

    public SocorristaMoto() {
    }

    public void socorrer(Moto moto) {
        System.out.printf("Socorriendo moto %s%n", moto.getPatente());
    }
}