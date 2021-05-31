package com.company;

public class SocorristaMoto implements Socorrista{

    public SocorristaMoto() {
    }

    @Override
    public void socorrer(Vehiculo unVehiculo) {
        System.out.println("Socorriendo moto");
        System.out.println("Patente: "+unVehiculo.getPatente());
    }
}
