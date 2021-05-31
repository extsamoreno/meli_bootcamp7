package Exercise2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    //Auto a1 = new Auto(123,1,2,"HOLA");
        //Auto a2 = new Auto(456,4,5,"CHAU");
        SocorristaMoto s1 = new SocorristaMoto(789,7,8, 450,"AYUDO MOTOS", (byte)3);
        SocorristaAuto s2 = new SocorristaAuto(789,7,8, 450,"AYUDO AUTOS", (byte)6);

        Carrera c1 = new Carrera(5000, 69, "Carrea 420", (short)5, s2, s1);
        c1.darDeAltaAuto(123,1,2,"HOLA");
        c1.darDeAltaAuto(456,4,5,"CHAU");
        c1.darDeAltaAuto(789,7,8,"ADIOS");
        c1.darDeAltaAuto(1000,78,100,"NV");


        try {
            c1.getGanador();
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.printVehiculos();

        c1.eliminarVehiculoConPatente("ADIOS");
        c1.printVehiculos();

        List<Vehiculo> autitos = c1.getVehiculos();
        c1.eliminarVehiculo(autitos.get(0));
        c1.printVehiculos();

        try {
            c1.socorrerAuto("NV");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            c1.socorrerMoto("NV");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
