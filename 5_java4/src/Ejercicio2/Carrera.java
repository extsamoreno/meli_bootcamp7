package Ejercicio2;
import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listadoVehiculos = new ArrayList<>();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > listadoVehiculos.size()){

            this.listadoVehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));
        }else {
            System.out.printf("Ya se supero la cantidad de vehiculos permitidos \nno se pudo agregar a %s \n", patente);
        }}


    public void darDeAlta(Vehiculo vehiculo){
        if(listadoVehiculos.size() < cantidadDeVehiculosPermitidos){

            this.listadoVehiculos.add(vehiculo);
        }else {
            System.out.printf("Ya se supero la cantidad de vehiculos permitidos \nno se pudo agregar a %s \n", vehiculo.getPatente());
        }
    }


    public void darDeAltaMoto(double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if(listadoVehiculos.size() < cantidadDeVehiculosPermitidos){

            this.listadoVehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
        }else {
            System.out.printf("Ya se supero la cantidad de vehiculos permitidos \nno se pudo agregar a %s \n", patente);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listadoVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listadoVehiculos.removeIf(vehiculo -> vehiculo.getPatente() == unaPatente );
        System.out.println("Se eliminó "+  unaPatente);
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