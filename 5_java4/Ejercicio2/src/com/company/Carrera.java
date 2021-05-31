package com.company;

import java.util.ArrayList;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaVehiculos;
    private SocorristaAuto sosAuto;
    private SocorristaMoto sosMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.sosAuto = new SocorristaAuto();
        this.sosMoto = new SocorristaMoto();
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() <= cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                '}';
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaVehiculos.size() <= cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculoEliminar){
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).equals(vehiculoEliminar)){
                listaVehiculos.remove(i);
            }
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getPatente() == unaPatente){
                listaVehiculos.remove(i);
            }
        }
    }

    // GANADOR
    public Vehiculo ganador(){
        double potenciaMax = 0;
        Vehiculo vehiculoGanador = null;
        for (Vehiculo participante : listaVehiculos) {
            double v = participante.getVelocidad();
            double a = participante.getAceleración();
            double ang = participante.getAnguloDeGiro();
            double p = participante.getPeso();
            double r = participante.getRuedas();

            double potenciaParticipante = (v * (0.5*a)) / (ang * (p - (r * 100)));
            if (potenciaParticipante > potenciaMax){
                potenciaMax = potenciaParticipante;
                vehiculoGanador = participante;
            }
        }
        return vehiculoGanador;
    }

    // SOCORRISTAS
    public void socorrerAuto(String patente){
        for (Vehiculo participante : listaVehiculos) {
            if (participante.getPatente() == patente){
                sosAuto.socorrer(participante);
            }
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo participante : listaVehiculos) {
            if (participante.getPatente() == patente){
                sosAuto.socorrer(participante);
            }
        }
    }


}
