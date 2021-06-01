package Ex2;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaMoto socorristaMoto;
    private SocorristaAuto socorristaAuto;

    public Carrera() {
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto =  new SocorristaMoto();
    }

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {

        if (this.vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo newAuto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.vehiculos.add(newAuto);
        }else {
            System.out.println("No hay mas cupo para agregar este auto");
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (this.vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo newMoto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.vehiculos.add(newMoto);
        }else {
            System.out.println("No hay mas cupo para agregar esta moto");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        for(Vehiculo v : this.vehiculos){
            if(v.getPatente() == unaPatente)
                this.vehiculos.remove(v);
        }
    }

    public String ganador(){
        String res = "No compitio nadie";
        int max = 0;
        for(Vehiculo v : this.vehiculos){
            if(v.getVelocidad()*(v.getAceleracion()/2)/(v.getAnguloDeGiro()*(v.getPeso() - v.getRuedas() * 100)) > max){
                res = v.getPatente();
            }
        }
        return res;

    }

    public void socorrerAuto(String patente){
        for(Vehiculo v : this.vehiculos){
            if(v.getPatente() == patente && v instanceof Auto){
                this.socorristaAuto.socorrer((Auto) v);
            }else{
                System.out.println("No existe un Auto con la patente : " + patente);
            }
        }


    }

    public void socorrerMoto(String patente){
        for(Vehiculo v : this.vehiculos){
            if(v.getPatente() == patente && v instanceof Moto){
                this.socorristaMoto.socorrer((Moto) v);
            }else{
                System.out.println("No existe una Moto con la patente : " + patente);
            }
        }
    }




}
