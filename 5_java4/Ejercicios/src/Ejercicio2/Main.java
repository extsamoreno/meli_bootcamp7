package Ejercicio2;

public class Main {
    public static void main(String[] args) {

        Vehiculo auto1 = new Auto(500, 50, 50, "asd123");
        Vehiculo auto2 = new Auto(500, 50, 50, "asd124");
        Vehiculo auto3 = new Auto(20, 50, 50, "asd125");
        Vehiculo moto1 = new Moto(20, 50, 50, "asd126");

        Carrera copaPiston = new Carrera(1000, 20000, "Copa Piston", 3);
        copaPiston.darDeAltaAuto(auto1.getVelocidad(), auto1.getAceleracion(), auto1.getAnguloDeGiro(), auto1.getPatente());
        copaPiston.darDeAltaAuto(auto2.getVelocidad(), auto2.getAceleracion(), auto2.getAnguloDeGiro(), auto2.getPatente());
        copaPiston.darDeAltaMoto(moto1.getVelocidad(), moto1.getAceleracion(), moto1.getAnguloDeGiro(), moto1.getPatente());
        copaPiston.eliminarVehiculo(auto1);
        System.out.println(copaPiston.getListaDeVehiculos().toString());
    }
}
