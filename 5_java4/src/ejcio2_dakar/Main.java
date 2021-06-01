package ejcio2_dakar;

public class Main {

    public static void main(String[] args) {

        Carrera c1 = new Carrera(20000, 20000, "Montoto Grand Prix", (short) 10);

        c1.darDeAltaAuto(132, 1.4, 90, "ABC");
        c1.darDeAltaAuto(320, 1.9, 45, "SpeedyCar");
        c1.darDeAltaAuto(110, 1.6, 70, "FGH");
        c1.darDeAltaAuto(40, 1.1, 360, "CatraminaCar");

        c1.darDeAltaMoto(132, 1.4, 90, "MNO");
        c1.darDeAltaMoto(320, 1.9, 45, "SpeedyBike");
        c1.darDeAltaMoto(110, 1.6, 70, "PQR");
        c1.darDeAltaMoto(40, 1.1, 360, "CatraminaBike");

        //String patenteAEliminar = "patenteInexistente";
        String patenteAEliminar = "ABC";
        try {
            c1.eliminarVehiculoConPatente(patenteAEliminar);
            System.out.println("\nEliminando el vehículo con patente: " + patenteAEliminar + "... OK");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Auto autoAEliminar = new Auto(10, 1, 1, "Vehiculo Inexistente");
        Auto autoAEliminar = new Auto(110, 1.6, 70, "FGH");
        try {
            c1.eliminarVehiculo(autoAEliminar);
            System.out.println(("\nEliminando el vehículo pasado como objeto" + autoAEliminar + "... OK"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setSocorristaAuto(new SocorristaAuto());
        c1.setSocorristaMoto(new SocorristaMoto());

        Auto autoASocorrer = new Auto(40, 1.1, 360, "CatraminaCar");
        Moto motoASocorrer = new Moto(110, 1.6, 70, "PQR");

        System.out.println("\nSocorriendo Auto...");
        c1.getSocorristaAuto().socorrer(autoASocorrer);

        System.out.println("\nSocorriendo Moto...");
        c1.getSocorristaMoto().socorrer(motoASocorrer);

        System.out.println("\nDefiniendo ganador...");
        Vehiculo vehiculoGanador = c1.definirGanador(c1.getVehiculos());
        System.out.println("El vehículo ganador es: " + vehiculoGanador);
    }
}
