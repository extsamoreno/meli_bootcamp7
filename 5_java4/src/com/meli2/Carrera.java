package com.meli2;

import java.util.ArrayList;

public class Carrera {
    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<Vehiculo>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno."); // Generar un error de sistema
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("Cupo lleno."); // Generar un error de sistema.
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if(listaDeVehiculos.contains(vehiculo)) {
            this.listaDeVehiculos.remove(vehiculo);
        } else {
            System.out.println("Vehiculo no encontrado"); // Generar un error de sistema.
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if (this.listaDeVehiculos.get(i).getPatente().equals(patente)) {
                this.listaDeVehiculos.remove(i);
                break;
            } else {
                System.out.println("Vehiculo no encontrado");
            }
        }
    }

    private  Vehiculo getVehiculoPorPatente(String patente) {
        for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
            return listaDeVehiculos.get(i);
        }
        return null;
    }

    public void socorrerAuto(String patente) {
        this.socorristaAuto.socorrer((Auto) this.getVehiculoPorPatente(patente));
    }

    public void socorrerMoto(String patente) {
        this.socorristaMoto.socorrer((Moto) this.getVehiculoPorPatente(patente));
    }

    public Vehiculo definirGanador() {
        double maxValor = 0;
        Vehiculo ganador = null;
        if (listaDeVehiculos.size() != 0) {
            for (int i = 0; i < listaDeVehiculos.size(); i++) {
                Vehiculo v = listaDeVehiculos.get(i);
                double auxValor = v.velocidad * (v.aceleracion / 2) / (v.anguloDeGiro * (v.peso - v.ruedas * 100));
                if (auxValor > auxValor) {
                    maxValor = auxValor;
                    ganador = v;
                }
            }
        }
        return ganador;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
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

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
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
}
