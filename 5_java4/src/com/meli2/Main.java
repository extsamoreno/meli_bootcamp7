package com.meli2;

public class Main {
    public static void main(String[] args) {
        Vehiculo auto1 = new Auto(500, 50, 50, "asd123");
        Vehiculo auto2 = new Auto(500, 50, 50, "asd124");
        Vehiculo auto3 = new Auto(20, 50, 50, "asd125");
        Vehiculo moto1 = new Moto(20, 50, 50, "asd126");
        Carrera copaPiston = new Carrera(1000, 20000, "Copa Piston", 3);
        copaPiston.darDeAltaAuto(auto1.velocidad, auto1.aceleracion, auto1.anguloDeGiro, auto1.patente);
        copaPiston.darDeAltaAuto(auto2.velocidad, auto2.aceleracion, auto2.anguloDeGiro, auto2.patente);
        copaPiston.darDeAltaMoto(moto1.velocidad, moto1.aceleracion, moto1.anguloDeGiro, moto1.patente);
        copaPiston.eliminarVehiculo(auto1);
        System.out.println(copaPiston.getListaDeVehiculos().toString());
    }
}
