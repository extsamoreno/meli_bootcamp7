package practicaTM.ejercicio2;

import java.lang.invoke.VarHandle;

public interface Socorrista {

    default void socorrerVehiculo( Vehiculo vehiculo) {
        System.out.println("Socorriendo: " + vehiculo + " patente: " + vehiculo.getPatente());
    }

}
