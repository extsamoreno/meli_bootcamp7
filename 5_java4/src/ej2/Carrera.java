package ej2;

import java.util.List;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> lVehiculos;
    private SocorristaAuto socoAuto = new SocorristaAuto();
    private SocorristaMoto socoMoto = new SocorristaMoto();

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> lVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.lVehiculos = lVehiculos;
    }

    public void darDeAltaAuto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro, String patente) throws Exception {
        if (lVehiculos.size()<cantidadDeVehiculosPermitidos){
            lVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }else {
            throw new Exception("Carrera llena");
        }
    };

    public void darDeAltaMoto(Integer velocidad,Integer aceleracion,Integer anguloDeGiro, String patente) throws Exception {
        if (lVehiculos.size()<cantidadDeVehiculosPermitidos){
            lVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }else {
            throw new Exception("Carrera llena");
        }
    };

    public void darDeAltaVehiculo(Vehiculo v) throws Exception {
        if (lVehiculos.size()<cantidadDeVehiculosPermitidos){
            lVehiculos.add(v);
        }else {
            throw new Exception("Carrera llena");
        }
    };

    public void eliminarVehiculo(Vehiculo vehiculo){
        lVehiculos.remove(vehiculo);
    };
    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo v: this.lVehiculos
             ) {
            if (v.patente.equals(unaPatente)){
                lVehiculos.remove(v);
                return;
            }
        }
    };

    public Vehiculo ganador(){
        double vel = 0;
        double maxVel = 0;
        Vehiculo currentWinner = null;
        for (Vehiculo v: lVehiculos
             ) {
            vel = v.velocidad * 0.5 * v.aceleracion / (v.anguloDeGiro*(v.pesoKg-v.ruedas * 100));
            if(vel > maxVel){
                maxVel = vel;
                currentWinner = v;
            }
        }
        return currentWinner;
    }

    public void socorrerAuto(String patente){
        this.socoAuto.socorrer((Auto) getVehiculoByPatente(patente));
    };
    public void socorrerMoto(String patente){
        this.socoMoto.socorrer((Moto) getVehiculoByPatente(patente));
    };


    private Vehiculo getVehiculoByPatente(String patente){
        for (Vehiculo v: this.lVehiculos
        ) {
            if (v.patente.equals(patente)){
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", lVehiculos={" + lVehiculsToStrign(lVehiculos) +
                "}}";
    }

    private StringBuilder lVehiculsToStrign(List<Vehiculo> lV){
        StringBuilder string = new StringBuilder();
        for (Vehiculo v: lV
             ) {
            string.insert(string.length(),"Clase " + v.getClass().getSimpleName() + ", Patente: " + v.patente + " / ");
        }
        return string;
    }

}
