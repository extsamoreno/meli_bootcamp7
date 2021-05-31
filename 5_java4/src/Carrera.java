import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia, premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos= new ArrayList<>();
    private SocorristaAuto socAuto;
    private SocorristaMoto socMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Auto x= new Auto(velocidad,aceleracion,anguloDeGiro,patente);
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(x);
        } else {
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto x= new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(x);
        } else {
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }

    public void eliminarVehiculo(Vehiculo x){
        if(listaDeVehiculos.contains(x)){
            listaDeVehiculos.remove(listaDeVehiculos.indexOf(x));
        } else {
            System.out.println("El vehiculo no se encuentra registrado para esta carrera");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).getPatente().equals(unaPatente)){
                listaDeVehiculos.remove(i);
                break;
            }
            if (i==listaDeVehiculos.size()-1) System.out.println("El vehiculo no fue encontrado");
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
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

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
}
