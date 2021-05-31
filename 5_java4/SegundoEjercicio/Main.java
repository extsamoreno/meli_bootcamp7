package SegundoEjercicio;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(400, 1000, "dakar", 3);
        Auto auto1 = new Auto(80, 10, 4, "autoabc");
        Auto auto2 = new Auto(90, 9, 5, "autodef");
        Moto moto1 = new Moto(70, 10, 3, "motoabc");
        Moto moto2 = new Moto(100, 12, 2, "motodef");
        try {
            carrera.darDeAltaAuto(80, 10, 4, "autoabc");
            carrera.darDeAltaAuto(90, 9, 5, "autodef");
            carrera.darDeAltaMoto(30, 10, 6, "motoabc");
            System.out.println(carrera.ganadorDeCarrera());
            carrera.socorrerAuto("autoabc");
            carrera.socorrerAuto("motoabc");
            carrera.socorrerMoto("motoabc");

        } catch (DakarException ex) {
            System.out.println("rompio " + ex.getMessage());
        }

    }

}
