package Ejercicio2;
import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listadoVehiculos;


    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(listadoVehiculos.size() < cantidadDeVehiculosPermitidos){

            this.listadoVehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
        }else {
            System.out.println("Ya se supero la cantidad de vehiculos permitidos");
        }}


    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(listadoVehiculos.size() < cantidadDeVehiculosPermitidos){

            this.listadoVehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        }else {
            System.out.println("Ya se supero la cantidad de vehiculos permitidos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listadoVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i = 0; i < listadoVehiculos.size(); i++) {
            if(listadoVehiculos.get(i).equals(unaPatente)){
                listadoVehiculos.remove(listadoVehiculos.get(i));
            }
        }
    }

    public Vehiculo ganador(){

        Vehiculo better = new Vehiculo();

        double betterPerformace = 0;

        for (Vehiculo v: listadoVehiculos) {
            if(v.performace() > betterPerformace){
                betterPerformace = v.performace();
                better = v;
            }
        }

        return better;
    }

}