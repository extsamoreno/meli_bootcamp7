package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("CARRERA!!");

        // Crear carrera
        Carrera prix1 = new Carrera(400, 5000, "Sahara", 5 );
        System.out.println(prix1);
        System.out.println(" ");

        // Crear Vehiculos
        //Auto carro1 = new Auto(300, 10, 2, "patente001C");
        //Auto carro2 = new Auto(200, 20, 2, "patente002C");
        //Moto moto1 = new Moto(350, 15, 5, "patente001M");

        // Agregar los vehiculos participantes a la carrera
        prix1.darDeAltaAuto(300, 10, 2, "patente001C");
        prix1.darDeAltaAuto(200, 20, 2, "patente002C");
        prix1.darDeAltaMoto(100, 15, 5, "patente001M");

        Vehiculo primerLugar = prix1.ganador();
        System.out.println("Vehiculo Ganador:");
        System.out.println(primerLugar);
        System.out.println(" ");

        // Llamar Socorrista
        prix1.socorrerAuto("patente001C");

    }
}
