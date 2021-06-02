package com.meli.ejercicio2;

import java.util.List;

public class Carrera {
    private float distancia;
    private float premio;
    private String nombre;
    private int cantidadV;
    private List<Vehiculo> listaV;

    public Carrera(float distancia, float premio, String nombre, int cantidadV) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadV = cantidadV;

    }
    public void darDeAltaAuto(float velocidad,float aceleracion,float anguloDeGiro,String patente){
        Vehiculo vehiculo = new Autos(velocidad,aceleracion,anguloDeGiro,patente);
        System.out.println("patente: " + patente);
        this.listaV.add(vehiculo);
    }
    public void darDeAltaMoto(float velocidad,float aceleracion,float anguloDeGiro,String patente){
        Vehiculo vehiculo = new Motos(velocidad,aceleracion,anguloDeGiro,patente);

        this.listaV.add(vehiculo);
    }
    public void eliminarVehiculo(Vehiculo vehiculo) throws Exception{
        if(this.listaV.contains(vehiculo)){
            listaV.remove(vehiculo);
        }
        else
        {
            throw new Exception("El vehiculo no existe");
        }
    }

    public void eliminarVehiculoConPatente(String patente) throws Exception{
        for(Vehiculo vehiculo:listaV){
            if(vehiculo.getPatente().equals(patente)){
                listaV.remove(vehiculo);
                break;
            }
            else
            {
                throw new Exception("No existe un vehiculo con esa patente");
            }
        }
    }

    public String Ganador() {
        float ganador = 0;
        float puntaje;
        String patenteG = "";
        for (Vehiculo vehiculo:listaV) {
            puntaje = ((1 / 2) * vehiculo.getVelocidad() * vehiculo.getAceleracion()) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if(puntaje>ganador){
                ganador = puntaje;
                patenteG = vehiculo.getPatente();
            }
        }
        return patenteG;
    }
    public void socorrerAuto(String patente){
        for(Vehiculo vehiculo:listaV){
            if (vehiculo.getPatente().equals(patente)){
                SocorristaAuto.socorrer(vehiculo);
            }
        }

    }

    public void socorrerMoto(String patente){
        for(Vehiculo vehiculo:listaV){
            if (vehiculo.getPatente().equals(patente)){
                SocorristaMoto.socorrer(vehiculo);
            }
        }

    }

}
