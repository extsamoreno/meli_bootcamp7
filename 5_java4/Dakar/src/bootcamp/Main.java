package bootcamp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Carrera carrera = new Carrera(
                200,5000,3,"Gran Bootcamp"
        );

        carrera.darDeAltaAuto("A4123",200,20,83.5);
        carrera.darDeAltaAuto("A4122313",300,10,13.5);
        carrera.darDeAltaMoto("MOTO3213",500,9,23.5);
        carrera.darDeAltaAuto("A31213",50,9,23.5);

        carrera.eliminarVehiculoConPatente("MOTO3213");
        carrera.darDeAltaAuto("A31213",50,9,23.5);


        System.out.println("carrera = " + carrera.ganador().patente);

        carrera.socorrerAuto("A4123");
        carrera.socorrerAuto("MOTO3213");
        carrera.socorrerMoto("MOTO3213");

    }
}
