package Ejercicio2;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Vehiculo v1 = new Auto();
        Vehiculo v2 = new Auto();
        Vehiculo v3 = new Moto();
        Vehiculo v4 = new Moto();
        v4.setPatente("1234");
        v2.setPatente("5678");
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        //listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);


        Carrera carrera = new Carrera(1000,5000,"Mega carreron",6,listaVehiculos);

        carrera.darDeAltaAuto(200, 3, 90, "patentosa");
        carrera.darDeAltaMoto(100, 6, 180, "patentemoto");
        // carrera.eliminarVehiculoConPatente("patentosa");

        carrera.darDeAltaAuto(500, 1, 90, "patentetest");

       /* Vehiculo sa = new SocorristaAuto();
        ((SocorristaAuto) sa).socorrer(v2);
        Vehiculo sm = new SocorristaMoto();
        ((SocorristaMoto) sm).socorrer(v4);
        */
        // Vehiculo sa = new SocorristaAuto();
        carrera.socorrerAuto("patentosa");
        carrera.socorrerMoto("patentemoto");
    }

}
