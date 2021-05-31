package Dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Carrera {
    private int distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList;
    private Vehiculo winner;

    public Carrera() {
        this.distancia = 0;
        this.premioEnDolares = 0;
        this.nombre = "";
        this.cantidadDeVehiculosPermitidos = 0;
        this.vehiculoList = new ArrayList<>();
        this.winner = null;
    }

    public Carrera(int distancia, float premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculoList) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculoList = vehiculoList;
    }

    public void darDeAltaAuto(float velocidad, int aceleracion, float anguloDeGiro, String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            vehiculoList.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Se agrego el vehiculo con exito");
        }else{
            System.out.println("No se pudo agregar el vehiculo");
        }
    }

    public void darDeAltaMoto(float velocidad,int aceleracion,float anguloDeGiro,String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            vehiculoList.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Se agrego el vehiculo con exito");
        }else{
            System.out.println("No se pudo agregar el vehiculo");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculoList.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculoToDelete = this.vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente))
                .collect(Collectors.toList())
                .get(0);

        eliminarVehiculo(vehiculoToDelete);
    }

    public Vehiculo getWinner(){

        for(Vehiculo vehiculo : vehiculoList){
            if (this.winner == null) {
                this.winner = vehiculo;
            }else{
                if(sacarPromedio(winner) < sacarPromedio(vehiculo)){
                    this.winner = vehiculo;
                }
            }
        }

        return this.winner;
    }

    public double sacarPromedio(Vehiculo vehiculo){
        return vehiculo.getVelocidad()
                * (vehiculo.getAcceleracion() / 2)
                / (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()
                - vehiculo.getRuedas() * 100));
    }

    public void socorrerVehiculo(String patente){
        Socorrista socorrista;
        Vehiculo vehiculoFind = this.vehiculoList.stream()
                                    .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                                    .collect(Collectors.toList())
                                    .get(0);

        switch(vehiculoFind.getClass().getSimpleName()){
            case "Auto":
                socorrista  = new SocorristaAuto();
                socorrista.socorrer(vehiculoFind);
                break;
            case "Moto":
                socorrista = new SocorristaMoto();
                socorrista.socorrer(vehiculoFind);
        }
    }


}
