package Excercise2;

import java.util.List;

public class Carrera {
    double distancia;
    double premioDolares;
    String nombre;
    int cantidadVehiculosPermitidos;
    List<Vehiculo> listaVehiculos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;



    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto "+ patente);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto "+ patente);
    }




    public void darDeAltaAuto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        Auto auto= new Auto();
        auto.setVelocidad(velocidad);
        auto.setAceleracion(aceleracion);
        auto.setAnguloDeGiro(AnguloDeGiro);
        auto.setPatente(patente);
        listaVehiculos.add(auto);
    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double AnguloDeGiro,String patente){
        Moto moto= new Moto();
        moto.setVelocidad(velocidad);
        moto.setAceleracion(aceleracion);
        moto.setAnguloDeGiro(AnguloDeGiro);
        moto.setPatente(patente);
        listaVehiculos.add(moto);
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        int eli=0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(listaVehiculos.get(i)==vehiculo){
                listaVehiculos.remove(i);
                eli++;
            }
        }
        if(eli>0){
            System.out.println("Se eliminaros los vehiculos");
        }
        else{
            System.out.println("No se encontraton vehiculos");
        }
    }


    public void eliminarVehiculoConPatente(String unaPatente){
        int eli=0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(listaVehiculos.get(i).patente==unaPatente){
                listaVehiculos.remove(i);eli++;
            }
        }
        if(eli>0){
            System.out.println("Se eliminaros los vehiculos con patente: "+unaPatente);
        }
        else{
            System.out.println("No se encontraton vehiculos con la patente: "+unaPatente);
        }
    }

    public Vehiculo ganador(){
        int pos=0;
        double mayor=0.0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo vehiculo=listaVehiculos.get(i);
            double valor= vehiculo.getVelocidad()*(1/2)*vehiculo.getAceleracion()/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(valor>=mayor){
                pos=i;
                mayor=valor;
            }
        }
        return listaVehiculos.get(pos);
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
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
}
