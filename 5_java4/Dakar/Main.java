package Dakar;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Carrera c1= new Carrera(1000,10000,"Carrera Vehiculos",5);
        c1.darDeAltaAuto(100,20,25,"AAA001");
        c1.darDeAltaAuto(90,20,30,"AAA002");
        c1.darDeAltaAuto(120, 24,28, "AAA003");
        c1.darDeAltaMoto(150, 30, 18, "AAB001");
        c1.darDeAltaMoto(80, 24,50,"AAB002");

        c1.eliminarVehiculoConPatente("AAA001");
        c1.darDeAltaMoto(130, 60,50,"AAB003");

        c1.socorrerAuto("AAA002");
        c1.socorrerMoto("AAB002");

        System.out.println("El vehiculo ganador de la carrera es: " + c1.ganadorCarrera().getPatente());





    }
}
