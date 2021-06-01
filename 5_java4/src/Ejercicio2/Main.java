package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500,300000, "Carrera1",5);
        carrera.darDeAltaAuto(50,30,10,"1234");
        carrera.darDeAltaAuto(100,20,20,"1235");
        carrera.darDeAltaAuto(80,50,30,"1236");
        carrera.darDeAltaMoto(70,50,25,"12347");
        carrera.darDeAltaMoto(90,10,35,"12348");
        carrera.darDeAltaMoto(80,80,15,"12349");
        carrera.socorrerAuto("1234");
        carrera.socorrerMoto("12348");
        carrera.ganadorCarrera();
    }
}
