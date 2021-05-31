package com.company;

public class SocorristaAuto implements Socorrista {

    public SocorristaAuto() {
    }

    @Override
    public void socorrer(Vehiculo unVehiculo) {
        System.out.println("Socorriendo auto");
        System.out.println("Patente: "+unVehiculo.getPatente());
    }
}
