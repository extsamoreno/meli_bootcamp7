package com.meli;

import java.util.ArrayList;
import java.util.Lista;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public Carrera() {
        this.listaDeVehiculos = new ArrayList<>();
    }


    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.removeIf(v -> (v.getPatente().equals(vehiculo.getPatente())));
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        this.listaDeVehiculos.removeIf(v -> (v.getPatente().equals(unaPatente)));
    }

    public Vehiculo definirGanador() {
        double cociente = 0;
        Vehiculo vehiculoGanador = new Vehiculo();
        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            if ((vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100))) > cociente)) {
                cociente =  (vehiculo.getVelocidad() * (0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100))));
                vehiculoGanador = vehiculo;
            }
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente) {
        Vehiculo auto = this.listaDeVehiculos.stream().filter(a -> a.getPatente().equals(patente)).findAny().orElse(null);
        this.socorristaAuto.socorrer((Auto) auto);
    }

    public void socorrerMoto(String patente) {
        Vehiculo moto = this.listaDeVehiculos.stream().filter(m -> m.getPatente().equals(patente)).findAny().orElse(null);
        this.socorristaMoto.socorrer((Moto) moto);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
}
