package Dakar;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Auto a1 = new Auto(100,180,80,"ASDA-234");
        Auto a2 = new Auto(120,180,80,"ASDA-277");
        Auto a3 = new Auto(120,190,80,"ASDA-229");

        List<Vehiculo> listado = new ArrayList<>();
        listado.add(a1);
        listado.add(a2);
        listado.add(a3);

        Carrera carrera = new Carrera(300, 500, "Copa Bootcamp", 4, listado);
        carrera.darDeAltaMoto(180,100,100,"ASDA-255");

        carrera.socorrerVehiculo("ASDA-277");
        carrera.socorrerVehiculo("ASDA-255");
        carrera.eliminarVehiculoConPatente(a3.getPatente());
        carrera.eliminarVehiculo(a2);
        System.out.println(carrera.getWinner().getClass().getSimpleName());

    }
}
