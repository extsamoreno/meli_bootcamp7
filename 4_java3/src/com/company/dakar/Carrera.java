package com.company.dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private float distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantVehiculos;
    private List<Vehiculo> lstVehiculos;
    private List<Socorrista> lstSocorristas;

    public Carrera() {
        lstVehiculos = new ArrayList<Vehiculo>();

        lstSocorristas = new ArrayList<Socorrista>();
        lstSocorristas.add(new SocorristaAuto());
        lstSocorristas.add(new SocorristaMoto());
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloGiro, String patente) {
        if (lstVehiculos.size() < cantVehiculos)
            lstVehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloGiro, String patente) {
        if (lstVehiculos.size() < cantVehiculos)
            lstVehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        lstVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        Vehiculo vehiculo = lstVehiculos.stream()
                .filter(patente -> patente.equals(unaPatente))
                .findAny()
                .orElse(null);

        eliminarVehiculo(vehiculo);
    }

    //TODO: Pueden haber dos ganadores
    public Vehiculo determinarGanador() {
        float velocidadMaxima = 0;
        Vehiculo vehiculoGanador = null;

        for (Vehiculo vehiculo : lstVehiculos) {
            if (vehiculo.calcularMaximaVelocidad() > velocidadMaxima)
                vehiculoGanador = vehiculo;
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String unaPatente) {
        Vehiculo vehiculo = lstVehiculos.stream()
                .filter(patente -> patente.equals(unaPatente))
                .findAny()
                .orElse(null);
        new SocorristaAuto().socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String unaPatente) {
        Vehiculo vehiculo = lstVehiculos.stream()
                .filter(patente -> patente.equals(unaPatente))
                .findAny()
                .orElse(null);
        new SocorristaMoto().socorrer((Moto) vehiculo);
    }
}
