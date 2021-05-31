package Ejercicio2;

public class Main {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(200, 1000, "ChampiosCarr", 2);

        Auto auto1 = new Auto(435, 20, 3, "OXP343");
        Auto auto2 =  new Auto(508.73, 50, 2, "XCO254" );

        carrera.darDeAltaAuto(400, 30, 2, "NEW231");
        carrera.darDeAlta(auto1);
        carrera.darDeAlta(auto2);
        carrera.eliminarVehiculoConPatente("OXP343");
        carrera.darDeAlta(auto2);

        carrera.eliminarVehiculoConPatente("NEW231");
        carrera.darDeAltaMoto(300,25, 2,"MOT233");

        System.out.println("Vehiculo ganador \n" + carrera.ganador());
    }
}
