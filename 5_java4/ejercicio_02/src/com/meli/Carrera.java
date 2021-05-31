package com.meli;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos= new ArrayList<>();
        this.socorristaAuto= new SocorristaAuto();
        this.socorristaMoto= new SocorristaMoto();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        } else {
            System.out.println("La cantidad de vehiculos permitida ha sido alcanzada");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        } else {
            System.out.println("La cantidad de vehiculos permitida ha sido alcanzada");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf((elem) -> elem.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double maximo= 0;
        for (Vehiculo v: vehiculos) {
            double max= v.getVelocidad()*(v.getVelocidad()*0.5)/
                    (v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if( max> maximo){
                maximo=max;
                ganador= v;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> auto = vehiculos.stream()
                .filter(x -> x.getPatente().equals(patente))
                .findFirst();
        if(auto.isPresent() && (auto.get() instanceof Auto)){
            socorristaAuto.socorrer((Auto) auto.get());
        }else{
            System.out.println("El socorrista no encontro el auto");
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> moto = vehiculos.stream()
                .filter(x -> x.getPatente().equals(patente))
                .findFirst();
        if(moto.isPresent() && (moto.get() instanceof Moto)){
            socorristaMoto.socorrer((Moto) moto.get());
        }else{
            System.out.println("El socorrista no encontro la moto");
        }
    }
}
