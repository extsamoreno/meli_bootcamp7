package dakar;

public class MainCarrera {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(
                200,5000,4,"Gran Bootcamp"
        );

        carrera.darDeAltaAuto("A4123",10001,20,83.5);
        carrera.darDeAltaAuto("A4122313",300,10,13.5);
        carrera.darDeAltaMoto("MOTO3213",500,9,23.5);
        carrera.darDeAltaAuto("A31213",50,9,23.5);

        carrera.eliminarVehiculoConPatente("A4122313");
        carrera.darDeAltaAuto("A31213",50,9,23.5);

        System.out.println(carrera.ganador());
        carrera.socorrerAuto("A4123");
        carrera.socorrerAuto("MOTO3213");
        carrera.socorrerMoto("MOTO3213");



    }
}
