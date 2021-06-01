package dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<dakar.Vehiculo> vehiculos;
    private dakar.SocorristaAuto socorristaAuto;
    private dakar.SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new dakar.SocorristaAuto();
        this.socorristaMoto = new dakar.SocorristaMoto();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        int cantVehiculosEnCarrera = vehiculos.size();

        if(cantVehiculosEnCarrera < cantidadDeVehiculosPermitidos) {
            dakar.Vehiculo auto = new dakar.Auto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(auto);
        } else {
            System.out.println("No se puede agregar el auto a la carrera. El cupo permitido ya fue llenado.");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        int cantVehiculosEnCarrera = vehiculos.size();

        if(cantVehiculosEnCarrera < cantidadDeVehiculosPermitidos) {
            dakar.Vehiculo moto = new dakar.Auto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(moto);
        } else {
            System.out.println("No se puede agregar la moto a la carrera. El cupo permitido ya fue llenado.");
        }
    }

    public void eliminarVehiculo(dakar.Vehiculo vehiculo) {
        if(vehiculos.contains(vehiculo)){
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("No existe el vehículo mencionado en la carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        int cantVehiculosEnCarrera = vehiculos.size();
        int flag = 0;

        for (int i = 0; i < cantVehiculosEnCarrera; i++) {
            if(vehiculos.get(i).getPatente() == patente){
                vehiculos.remove(i);
                flag = 1;
            }
            break;
        }

        if(flag == 1){
            System.out.println("La patente mencionada no corresponde a ningún vehículo en la carrera");
        }
    }

    public dakar.Vehiculo definirGanadorCarrera(){
        int cantVehiculosEnCarrera = vehiculos.size();
        double maxValor = 0;
        dakar.Vehiculo vehiculoGanador = vehiculos.get(0);

        for(int i = 0; i< cantVehiculosEnCarrera; i++){
            dakar.Vehiculo v = vehiculos.get(i);
            double valor = (v.getVelocidad()* (v.getAceleracion()/2)/ v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas() *100));

            if(valor > maxValor){
                maxValor = valor;
                vehiculoGanador = v;
            }
        }

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        int cantVehiculosEnCarrera = vehiculos.size();
        int flagInstancia = 0;
        int flagVehiculo = 0;

        for(int i = 0; i< cantVehiculosEnCarrera; i++){
            dakar.Vehiculo vehiculoASocorrer = vehiculos.get(i);

            if(vehiculoASocorrer.getPatente() == patente){
                socorristaAuto.socorrer((dakar.Auto) vehiculoASocorrer);
            } else if (! (vehiculoASocorrer instanceof dakar.Auto)) {
                flagInstancia = 1;
            } else {
                flagVehiculo = 1;
            }
        }

        if(flagInstancia == 1){
            System.out.println("La patente especificada no es de una moto");
        }

        if(flagVehiculo == 1){
            System.out.println("El vehículo socorrista no pudo hallar el auto");
        }
    }
    public void socorrerMoto(String patente){
        int cantVehiculosEnCarrera = vehiculos.size();
        int flagInstancia = 0;
        int flagVehiculo = 0;

        for(int i = 0; i< cantVehiculosEnCarrera; i++){
            dakar.Vehiculo vehiculoASocorrer = vehiculos.get(i);

            if(vehiculoASocorrer.getPatente() == patente && vehiculoASocorrer instanceof dakar.Moto){
                socorristaMoto.socorrer((dakar.Auto) vehiculoASocorrer);
            } else if (! (vehiculoASocorrer instanceof  dakar.Moto)) {
                flagInstancia = 1;
            } else {
                flagVehiculo = 1;
            }
        }

        if(flagInstancia == 1){
            System.out.println("La patente especificada no es de una moto");
        }

        if(flagVehiculo == 1){
            System.out.println("El vehículo socorrista no pudo hallar el auto");
        }
    }
}