package com.company.Clase4Java.Ejercicio2;

public class SocorristaMoto extends Vehiculo implements Socorrista {


    @Override
    public void socorrer(Vehiculo vehiculo) throws DakarException {
        if (vehiculo instanceof Moto) {
            System.out.println("Socorriendo: " + vehiculo);
        } else throw new DakarException("Solo puedo socorrer motos");
    }
}