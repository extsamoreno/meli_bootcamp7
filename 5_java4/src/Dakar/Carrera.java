package Dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private short cantidadVehiculosPermitidos;
    private ArrayList<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
        this.vehiculos = new ArrayList<Vehiculo>();
        this.cantidadVehiculosPermitidos = 5;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, int anguloDeGiro, String patente) {
        if (getVehiculos().size() < this.cantidadVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, int anguloDeGiro, String patente) {
        if (getVehiculos().size() < this.cantidadVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (!vehiculos.isEmpty()) {
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("No hay vehiculos registrados");
        }
    }

    public void eliminarVehiculoConPatente(String patente){

        if (!vehiculos.isEmpty()) {
            vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        } else {
            System.out.println("No hay vehiculos registrados");
        }
        /*    for(Vehiculo v:vehiculos){
            if(patente.equals(v.patente)){
                vehiculos.remove(v);
                break;
            }
        }
     */
    }

    public void socorrerAuto(String patente){
        if (patente != null) {
            for (Vehiculo v : vehiculos) {
                if (patente.equals(v.patente)) {
                    vehiculos.remove(v);
                    break;
                }
            }
            System.out.println("Vehiculo no registrado");
        }
    }

    public void socorrerMoto(String patente){
        if (patente != null) {
            for (Vehiculo v : vehiculos) {
                if (patente.equals(v.patente)) {
                    vehiculos.remove(v);
                    break;
                }
            }
            System.out.println("Vehiculo no registrado");
        }
    }

    //Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    public Vehiculo vehiculoGanador(){

        float max = 0;
        float aux = 0;
        Vehiculo vehiculoGanador = null;

        for(Vehiculo v: vehiculos){

            aux = (float) (((v.getVelocidad() * 0.5 * v.getAceleracion())) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100)));

            if(aux > max) {
                max = aux;
                vehiculoGanador = v;
            }
        }

        if(max > 0){
            return vehiculoGanador;
        }else{
            return null;
        }
    }
}