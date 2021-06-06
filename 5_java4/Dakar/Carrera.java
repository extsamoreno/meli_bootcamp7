package Dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;
    Socorrista<Auto> socorristaAuto;
    Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre,
                   int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Auto a = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (cantidadDeVehiculosPermitidos > vehiculoList.size()) {
            vehiculoList.add(a);
        } else {
            System.out.println("Ya no se pueden agregar más autos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Moto m = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (cantidadDeVehiculosPermitidos > vehiculoList.size()) {
            vehiculoList.add(m);
        } else {
            System.out.println("Ya no se pueden agregar más motos");
        }
    }

    public void eliminarVehiculo(Vehiculo v) {
        this.vehiculoList.remove(v);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        List<Vehiculo> filteredVehiculos = this.vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente))
                .collect(Collectors.toList());
        try {
            eliminarVehiculo(filteredVehiculos.get(0));
            System.out.println("El vehiculo fue eliminado exitosamente");
        } catch (Exception e) {
            System.out.println("No existe un vehículo con esa patente");
        }
    }

    public Vehiculo ganadorCarrera() {
        double max = 0;
        int ganadorIndex = 0;
        Vehiculo ganador;
        for (int i = 0; i < vehiculoList.size(); i++) {
            ganador = vehiculoList.get(i);
            if (ganador.calcularMaximaVelocidad() > max) {
                max = ganador.calcularMaximaVelocidad();
                ganadorIndex = i;
            }
        }
        return vehiculoList.get(ganadorIndex);
    }

    public void socorrerAuto(String patente) {
        try {
            this.socorristaAuto.socorrer(
                    (Auto) findVehiculoPatente(patente)
            );
        } catch (Exception e) {
            System.out.println("No se tiene registro de este auto");
        }
    }

    public void socorrerMoto(String patente) {
        try {
            this.socorristaMoto.socorrer(
                    (Moto) findVehiculoPatente(patente)
            );
        } catch (Exception e) {
            System.out.println("No se tiene registro de esta moto");
        }
    }

    public Vehiculo findVehiculoPatente(String patente) {
        List<Vehiculo> listVehiculos = this.vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .collect(Collectors.toList());
        try {
            return listVehiculos.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

