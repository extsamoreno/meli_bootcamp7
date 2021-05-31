package com.company.CM.Ejercicio_2;

import java.util.ArrayList;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, ArrayList<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
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

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloDeGiro,String patente){

        int vehiculosActuales = listaDeVehiculos.size();
        if(cantidadDeVehiculosPermitidos >= vehiculosActuales){
            Vehiculo auto = new Autos(velocidad,aceleracion,anguloDeGiro, patente);
            listaDeVehiculos.add(auto);
        }

        //System.out.println(listaDeVehiculos);
    }
    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro,String patente){

        int vehiculosActuales = listaDeVehiculos.size();
        if(cantidadDeVehiculosPermitidos >= vehiculosActuales){
            Vehiculo moto = new Motos(velocidad,aceleracion,anguloDeGiro, patente);
            listaDeVehiculos.add(moto);
        }

        System.out.println(listaDeVehiculos);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){


        if(listaDeVehiculos.contains(vehiculo)){
             listaDeVehiculos.remove(vehiculo);
        }
    }
    public void eliminarVehiculoConPatente(String unaPatente){


        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).getPatente() == unaPatente){
                listaDeVehiculos.remove(i);
            }
        }
    }
    public Vehiculo determinarGanador(){

        double maxValor = 0;
        Vehiculo vehiculoGanador = listaDeVehiculos.get(0);

        for(int i = 0; i< listaDeVehiculos.size(); i++){
            Vehiculo v = listaDeVehiculos.get(i);
            double valor = (v.getVelocidad()* (v.getAceleracion()/2)/ v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas() *100));

            if(valor > maxValor){
                maxValor = valor;
                vehiculoGanador = v;
            }
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){

        SocorristaAuto sa = new SocorristaAuto();
        for(int i = 0; i< listaDeVehiculos.size(); i++){

            Vehiculo v = listaDeVehiculos.get(i);

            if(v.getPatente() == patente){
                sa.socorrer(v);
            }
        }
    }
    public void socorrerMoto(String patente){

        SocorristaMoto sm = new SocorristaMoto();
        for(int i = 0; i< listaDeVehiculos.size(); i++){

            Vehiculo v = listaDeVehiculos.get(i);

            if(v.getPatente() == patente){
                sm.socorrer(v);
            }
        }
    }
}
