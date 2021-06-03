package com.meli.tm.ex2;

public class MainDakar {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(5000, 30000, "DAKAR", 5);
        carrera.darAltaAuto(130, 10, 15, "DAK001");
        carrera.darAltaAuto(120, 12, 10, "DAK002");
        carrera.darAltaMoto(150, 9, 15, "DAK003");
        carrera.darAltaMoto(110, 15, 12, "DAK004");
        carrera.darAltaAuto(130, 10, 15, "DAK005");

        carrera.eliminarVehiculoConPatente("DAK002");

        carrera.socorrerAuto("DAKOO1");
        carrera.socorrerAuto("DAK005");

        carrera.socorrerMoto("DAK003");
        carrera.socorrerMoto("DAK004");

        System.out.println(carrera.definirGanador());
    }

}
