package dakar;

public class Main {
    public static void main(String[] args) {
        dakar.Carrera carrera= new dakar.Carrera(1000,10000,"Carrera Vehiculos",3);
        carrera.darDeAltaAuto(100,10,1, "ABC123");
        carrera.darDeAltaAuto(200,20,2, "DEF456");
        carrera.darDeAltaMoto(300,30,3,"GHI789");

        carrera.eliminarVehiculoConPatente("DEF456");

        carrera.socorrerAuto("ABC123");

        carrera.socorrerMoto("GHI789");

        dakar.Vehiculo vehiculoGanador = carrera.definirGanadorCarrera();

        System.out.println("El ganador de la carrera es " + vehiculoGanador);
    }
}