package Dakar;

import java.util.ArrayList;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;

    public ArrayList<Vehiculo> getListavehiculos() {
        return listavehiculos;
    }

    public void setListavehiculos(ArrayList<Vehiculo> listavehiculos) {
        this.listavehiculos = listavehiculos;
    }

    ArrayList<Vehiculo> listavehiculos = new ArrayList<>();
    private SocorristaAuto socAuto;

    public SocorristaAuto getSocAuto() {
        return socAuto;
    }

    public void setSocAuto(SocorristaAuto socAuto) {
        this.socAuto = socAuto;
    }

    public SocorristaMoto getSocMoto() {
        return socMoto;
    }

    public void setSocMoto(SocorristaMoto socMoto) {
        this.socMoto = socMoto;
    }

    private SocorristaMoto socMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
        Auto auto1= new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if(listavehiculos.size() < cantidadDeVehiculosPermitidos){
            listavehiculos.add(auto1);
        }else{
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro,String patente){
          Moto moto1 = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if(listavehiculos.size()<cantidadDeVehiculosPermitidos){
            listavehiculos.add(moto1);
        } else {
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }
    public void eliminarVehiculo(Vehiculo x){
        if(listavehiculos.contains(x)){
            listavehiculos.remove(listavehiculos.indexOf(x));
        } else {
            System.out.println("El vehiculo no se encuentra registrado para esta carrera");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i = 0; i < listavehiculos.size(); i++) {
            if(listavehiculos.get(i).getPatente().equals(unaPatente)){
                listavehiculos.remove(i);
                break;
            }
            if (i==listavehiculos.size()-1) System.out.println("El vehiculo no fue encontrado");
        }
    }
    public void socorrerMoto(String patente){
        for (int i = 0; i < listavehiculos.size(); i++) {
            if(listavehiculos.get(i).getPatente().equals(patente)){
                socMoto.socorrer((Moto) listavehiculos.get(i));
                break;
            }
            if (i==listavehiculos.size()-1) System.out.println("El vehiculo no fue encontrado con la patente mencionada");
        }
    }
    public void socorrerAuto(String patente){
        for (int i = 0; i < listavehiculos.size(); i++) {
            if(listavehiculos.get(i).getPatente().equals(patente)){
                socAuto.socorrer((Auto) listavehiculos.get(i));
                break;
            }
            if (i==listavehiculos.size()-1) System.out.println("El vehiculo no fue encontrado con la patente mencionada");
        }
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
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
        cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }


}
