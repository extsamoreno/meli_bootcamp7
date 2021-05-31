package com.company.ej2;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculo;
    private Socorrista socAuto;
    private Socorrista socMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantDeVehiculosPermitidos,
                   SocorristaAuto socAuto, SocorristaMoto socMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
        this.listaVehiculo = new ArrayList<>();
        this.socAuto = socAuto;
        this.socMoto = socMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculo.size() < cantDeVehiculosPermitidos) {
            Vehiculo v  = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculo.add(v);
        } else {
            System.out.println("ALTA AUTO - Ya se alcanzó la máxima cantidad de participantes.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculo.size() < cantDeVehiculosPermitidos) {
            Vehiculo v  = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculo.add(v);
        } else {
            System.out.println("ALTA MOTO - Ya se alcanzó la máxima cantidad de participantes.");
        }
    }

    // esto hay que ver como hacerlo
    public void eliminarVehiculo(Vehiculo vehiculo) {

        for (Vehiculo v : listaVehiculo) {
            if(v.equals(vehiculo)) {
                listaVehiculo.remove(v);
                System.out.println("Se elimino a " + v.getPatente() + " de la carrera.");
                return;
            }
        }

    }

    public void eliminarVehiculoConPatente(String patente) {

        Vehiculo v = buscarPorPatente(patente);

        if(v != null) { //checkear esto no se si te dejaba comparar por null
            listaVehiculo.remove(v);
            System.out.println("Se elimino a " + v.getPatente() + " de la carrera.");
        }

    }

    public Vehiculo definirGanador() {
        // Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        double max = -1.00;
        double temp;
        Vehiculo ganador = new Moto(1,1,1,"1");

        for (Vehiculo v : listaVehiculo) {
            temp = (v.getVelocidad() * (v.getAceleracion()/2) / (v.getAnguloDeGiro() *
                    v.getPeso() - (v.getRuedas() * 100)));
            if(temp > max) {
                ganador = v;
                max = temp;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        Vehiculo v = buscarPorPatente(patente);
        socAuto.socorrer(v);
    }

    public void socorrerMoto(String patente) {
        Vehiculo v = buscarPorPatente(patente);
        socMoto.socorrer(v);
    }

    public Vehiculo buscarPorPatente(String patente) {

        for (Vehiculo v : listaVehiculo) {
            if(v.getPatente().equals(patente)) {
                return v;
            }
        }

        return null;

    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDeVehiculosPermitidos() {
        return cantDeVehiculosPermitidos;
    }

    public void setCantDeVehiculosPermitidos(int cantDeVehiculosPermitidos) {
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public Socorrista getSocAuto() {
        return socAuto;
    }

    public void setSocAuto(Socorrista socAuto) {
        this.socAuto = socAuto;
    }

    public Socorrista getSocMoto() {
        return socMoto;
    }

    public void setSocMoto(Socorrista socMoto) {
        this.socMoto = socMoto;
    }

}
