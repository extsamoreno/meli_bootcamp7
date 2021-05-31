package practicaTM.ejercicio2;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private Integer cantVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private SocorristaAuto socoAuto = new SocorristaAuto();
    private SocorristaMoto socoMoto = new SocorristaMoto();

    public Carrera(double distancia, double premioEnDolares, String nombre, Integer cantVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) throws DakarException {
        if (vehiculos.size() < cantVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
        } else throw new DakarException("No hay cupo");

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente) throws DakarException {
        if (vehiculos.size() < cantVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        } else throw new DakarException("No hay cupo");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculos.indexOf(vehiculo));
    }

    public void eliminarVehiculoConPatente(String unaPatente) throws DakarException {
        Vehiculo v = findByPatente(unaPatente);
        eliminarVehiculo(v);
    }

    private Vehiculo findByPatente(String unaPatente) throws DakarException {
        Vehiculo v = vehiculos.stream().filter(elem -> elem.getPatente() == unaPatente)
                .findFirst()
                .orElseThrow(() -> new DakarException("No se encontro vehiculo"));
        return v;
    }

    public double calcularValor(Vehiculo vehiculo) {
        return vehiculo.getVelocidad()
                * 0.5 * vehiculo.getAceleracion() /
                (vehiculo.getAngulo() *
                        (vehiculo.getPeso() - vehiculo.getRuedas() * 100)
                );
    }

    public Vehiculo ganadorDeCarrera() throws DakarException {
        return (vehiculos.stream().max(
                Comparator.comparing(v -> calcularValor(v)))
        ).orElseThrow(() -> new DakarException("No hay ganador"));
    }

    public void socorrerAuto(String patente) throws DakarException {
        Auto auto = (Auto) findByPatente(patente);
        socoAuto.socorrer(auto);
    }

    public void socorrerMoto(String patente) throws DakarException {
        Moto moto = (Moto) findByPatente(patente);
        socoMoto.socorrer(moto);
    }
}
