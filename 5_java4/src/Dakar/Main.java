package Dakar;

public class Main {
    public static void main(String[] args) {
        Carrera Dakar = new Carrera();

        Dakar.darDeAltaAuto(123,1,2,"HOLA");
        Dakar.darDeAltaAuto(456,4,5,"CHAU");
        Dakar.darDeAltaAuto(789,7,8,"ADIOS");
        Dakar.darDeAltaAuto(1000,78,100,"NV");

        Dakar.vehiculoGanador();
        System.out.println("Vehiculo Ganador: " + Dakar.vehiculoGanador().getVelocidad());

    }
}
