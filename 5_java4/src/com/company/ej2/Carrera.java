package com.company.ej2;

import java.util.ArrayList;

public class Carrera {

    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private AutoSocorrista autoSocorrista;
    private MotoSocorrista motoSocorrista;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno.");
        }

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {

        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno.");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (!listaDeVehiculos.contains(vehiculo)) {
            System.out.println("Vehiculo no encontrado.");
        } else {
            this.listaDeVehiculos.remove(vehiculo);
        }
    }

    private Vehiculo getVehiculo(String patente){

        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).patente.equals(patente)) {
                return listaDeVehiculos.get(i);
            }
        }
        return null;
    }

    public void socorrerAuto(String patente){

        this.autoSocorrista.socorrer((Auto) this.getVehiculo(patente));
    }

    public void socorrerMoto(String patente){

        this.motoSocorrista.socorrer((Moto) this.getVehiculo(patente));
    }

    public void eliminarVehiculoConPatente(String unaPatente) {

        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (listaDeVehiculos.get(i).patente.equals(unaPatente)) {
                listaDeVehiculos.remove(i);
                break;
            }
        }

    }

    public Vehiculo definirGanador() {
        double maxValor = 0;
        Vehiculo ganador = null;
        if (listaDeVehiculos.size() != 0) {
            for (int i = 0; i < listaDeVehiculos.size(); i++) {
                Vehiculo v = listaDeVehiculos.get(i);
                double auxValor = v.velocidad * (v.aceleracion / 2) / (v.anguloDeGiro * (v.peso - v.ruedas * 100));
                if (auxValor > maxValor) {
                    maxValor = auxValor;
                    ganador = v;
                }

            }
        }

        return ganador;

    }


        public int getDistancia () {
            return distancia;
        }

        public void setDistancia ( int distancia){
            this.distancia = distancia;
        }

        public double getPremioEnDolares () {
            return premioEnDolares;
        }

        public void setPremioEnDolares ( double premioEnDolares){
            this.premioEnDolares = premioEnDolares;
        }

        public String getNombre () {
            return nombre;
        }

        public void setNombre (String nombre){
            this.nombre = nombre;
        }

        public int getCantidadDeVehiculosPermitidos () {
            return cantidadDeVehiculosPermitidos;
        }

        public void setCantidadDeVehiculosPermitidos ( int cantidadDeVehiculosPermitidos){
            this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        }

        public ArrayList<Vehiculo> getListaDeVehiculos () {
            return listaDeVehiculos;
        }

        public void setListaDeVehiculos (ArrayList < Vehiculo > listaDeVehiculos) {
            this.listaDeVehiculos = listaDeVehiculos;
        }
    }
