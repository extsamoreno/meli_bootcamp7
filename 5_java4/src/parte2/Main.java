package parte2;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        Carrera carrera1= new Carrera(1000,10000,"DO",5);
        carrera1.darDeAltaAuto(100,15,15, "ACD223");
        carrera1.darDeAltaAuto(98,10,10, "ACD281");
        carrera1.darDeAltaMoto(115,9,15,"EHS695");
        carrera1.darDeAltaMoto(125,8,12,"ACD281");
        carrera1.darDeAltaAuto(150,300,15, "ACD224");


        carrera1.eliminarVehiculoConPatente("EBS695");

        carrera1.socorrerAuto("a65d64");
        carrera1.socorrerAuto("ACD281");
        carrera1.socorrerAuto("EHS695");

        carrera1.socorrerMoto("a65d64");
        carrera1.socorrerMoto("ACD281");
        carrera1.socorrerMoto("EHS695");

        System.out.println(carrera1.definirGanador());

    }
}
