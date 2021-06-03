package com.meli.tm.ex2;

public class SocorristaMoto extends Vehiculo {
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto :" + moto.getPatente());
    }
}
