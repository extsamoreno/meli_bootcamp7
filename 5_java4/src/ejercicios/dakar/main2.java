package ejercicios.dakar;

import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) {

        ArrayList<Vehiculo> lista = new ArrayList<>();
        Auto auto1 = new Auto(150,3.5f,120.3f,"RCQ485");
        lista.add(auto1);

        Carrera carrera = new Carrera(1000,12300, 10,"Dakar Meli",lista );
        carrera.darDeAltaAuto(113,4.3f,45,"HQY223");
        carrera.darDeAltaAuto(167,7.8f,80,"HJK361");
        carrera.darDeAltaAuto(167,7.8f,67,"ACV379");
        carrera.darDeAltaMoto(77,5.6f,34,"GHJ321");
        carrera.darDeAltaMoto(90,10.5f,34,"TRF093");

        carrera.socorrerAuto("HQ223");
        carrera.socorrerMoto("TRF03");

        carrera.eliminarVehiculo(auto1);
        carrera.eliminarVehiculoPorPatente("ACV379");

        carrera.ganadorDeCarrera();

    }
}
