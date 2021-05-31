package dakar;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Carrera {

    private double distancia;
    private String nombre;
    private int cantidadDeVehiculosPermitidos, premioEnDolares;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos)
            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos)
            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        if (this.vehiculos.contains(vehículo))
            this.vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        this.vehiculos.stream().forEach(vehiculo -> {
            if (unaPatente.equals(vehiculo.getPatente()))
                this.eliminarVehiculo(vehiculo);
        });
    }

    public Vehiculo determinarGanador(){
        double resultado = 0;
        Vehiculo ganador = null;

        for (Vehiculo vehiculo: this.vehiculos) {
            double ref = vehiculo.getVelocidad()*(0.5*vehiculo.getAceleracion())/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()* 100));
            if (ref > resultado){
                resultado = ref;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente){
        this.vehiculos.stream().forEach(vehiculo -> {
            if (patente.equals(vehiculo.getPatente()))
                this.socorristaAuto.socorrer((Auto) vehiculo);
        });
    }

    public void socorrerMoto(String patente){
        this.vehiculos.stream().forEach(vehiculo -> {
            if (patente.equals(vehiculo.getPatente()))
                this.socorristaMoto.socorrer((Moto) vehiculo);
        });
    }

}


