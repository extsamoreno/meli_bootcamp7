package com.company.ej2;

import java.util.ArrayList;

public class Carrera {

    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){

        if(this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno.");
        }

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){

        if(this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno.");
        }

    }

    public void eliminarVehiculo(Vehiculo vehículo){
        if(!this.listaDeVehiculos.contains(vehículo)){
            System.out.println("Vehiculo no encontrado.");
        } else {
            listaDeVehiculos.remove(vehículo);
        }
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
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

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
