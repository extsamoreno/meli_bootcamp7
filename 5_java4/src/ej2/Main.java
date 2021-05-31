package ej2;

import com.ej1.Campera;
import com.ej1.GuardaRopa;
import com.ej1.Prenda;
import com.ej1.Remera;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var carrera1 = new Carrera(20,200,"la super carrera",4,new ArrayList<Vehiculo>());

        var vehiculo1 = new Auto(1,1,1, "auto1");
        var vehiculo2 = new Auto(1,1,1, "auto2");
        var vehiculo3 = new Moto(1,1,1, "moto1");
        var vehiculo4 = new Moto(1,1,1, "moto2");
//        try {
//            carrera1.darDeAltaAuto(1,1,1,"asd1");
//            carrera1.darDeAltaAuto(1,1,1,"asd2");
//            carrera1.darDeAltaMoto(1,1,1,"asd3");
//            carrera1.darDeAltaMoto(1,1,1,"asd4");
//            //carrera1.darDeAltaMoto(1,1,1,"asd4");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try{
            carrera1.darDeAltaVehiculo(vehiculo1);
            carrera1.darDeAltaVehiculo(vehiculo2);
            carrera1.darDeAltaVehiculo(vehiculo3);
            carrera1.darDeAltaVehiculo(vehiculo4);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(carrera1);

        carrera1.eliminarVehiculo(vehiculo2);
        carrera1.eliminarVehiculoConPatente("moto2");

        System.out.println(carrera1);
        System.out.println("Ganador:" + carrera1.ganador());

        carrera1.socorrerAuto("auto1");
        carrera1.socorrerMoto("moto1");

        carrera1.socorrerAuto("auto2");
        carrera1.socorrerMoto("moto2");


    }
}
