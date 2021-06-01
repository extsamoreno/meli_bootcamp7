package meli.ejerc.SegundoEjercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    int distancia;
    int premioEnDolares;
    String nombre;
    int cantidadVehiculosPermitidos;
    List<Vehiculo> participantes;
    Socorrista<Moto> socorristaMoto;
    Socorrista<Auto> socorristaAuto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.participantes = new ArrayList<Vehiculo>(cantidadVehiculosPermitidos);
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (participantes.size() < cantidadVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            participantes.add(auto);
        } else System.out.println("No se puede agregar mas vehiculos a la carrera");
    }

    public void darDeAltaMoto(double velocidad,double aceleracion, double anguloDeGiro, String patente){
        if (participantes.size() < cantidadVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            participantes.add(moto);
        } else System.out.println("No se puede agregar mas vehiculos a la carrera");
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (this.participantes.contains(vehiculo.patente)){
            this.participantes.remove(vehiculo);
        }
        else System.out.println("El vehiculo no existe");
    }

    public void eliminarVehiculosConPatente (String unaPatente) {
        if (this.participantes.stream().anyMatch(vehiculo -> vehiculo.getPatente().equals(unaPatente))) {
            this.participantes.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
        } else System.out.println("El vehiculo no existe");
    }

    public Vehiculo getGanador() {
        double maximo = 0;
        Vehiculo ganador = new Vehiculo();
        for (Vehiculo v : participantes) {
            double aux = v.velocidad * 0.5 * v.aceleracion / (v.radioDeGiro*(v.peso-v.cantRuedas*100));
            if (aux  > maximo) {
                ganador = v;
            }
        }
        return ganador;
    }

    public Vehiculo getVehiculo (String patente){
        for (Vehiculo v : this.participantes) {
            if (v.getPatente().equals(patente)) {
                return v;
            }
        }
        return null;
    }

    public void socorrerAuto(String patente) {
        if (getVehiculo(patente) instanceof Auto) {
            this.socorristaAuto.socorrer((Auto) getVehiculo(patente));
        } else System.out.println("El socorrista no puede asistir a este tipo de vehiculo");
    }

    public void socorrerMoto(String patente) {
        if (getVehiculo(patente) instanceof Moto) {
            this.socorristaMoto.socorrer((Moto) getVehiculo(patente));
        } else System.out.println("El socorrista no puede asistir a este tipo de vehiculo");
    }
}
