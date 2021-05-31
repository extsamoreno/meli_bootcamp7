package com.meli;

public class Main {

    public static void main(String[] args) {
        Carrera carrera= new Carrera(1000,10000,"Carrera Vehiculos",5);
        carrera.darDeAltaAuto(100,15,15, "ACD223");
        carrera.darDeAltaAuto(98,10,10, "ACD281");
        carrera.darDeAltaMoto(115,9,15,"EHS695");
        carrera.darDeAltaMoto(125,8,12,"ACD281");
        carrera.darDeAltaAuto(150,300,15, "ACD224");

        carrera.eliminarVehiculoConPatente("EBS695");

        carrera.socorrerAuto("ACD281");
        carrera.socorrerAuto("EHS695");

        carrera.socorrerMoto("ACD281");
        carrera.socorrerMoto("EHS695");

        System.out.println(carrera.definirGanador());
    }
}
