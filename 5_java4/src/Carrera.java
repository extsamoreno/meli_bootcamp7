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
            System.out.println("Vehiculo agregado exitosamente");
        } else {
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        Moto x= new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(x);
            System.out.println("Vehiculo agregado exitosamente");
        } else {
            System.out.println("Ya se llenó el cupo máximo de vehiculos disponibles");
        }
    }

    public void eliminarVehiculo(Vehiculo x){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).equals(x)){
                listaDeVehiculos.remove(i);
                System.out.println("Vehiculo eliminado exitosamente");
                break;
            }
            if (i==listaDeVehiculos.size()-1) System.out.println("El vehiculo no fue encontrado");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).getPatente().equals(unaPatente)){
                listaDeVehiculos.remove(i);
                System.out.println("Vehiculo eliminado exitosamente");
                break;
            }
            if (i==listaDeVehiculos.size()-1) System.out.println("El vehiculo no fue encontrado con la patente mencionada");
        }
    }

    public void socorrerAuto(String patente){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).getPatente().equals(patente)){
                socAuto.socorrer((Auto) listaDeVehiculos.get(i));
                break;
            }
            if (i==listaDeVehiculos.size()-1) System.out.println("El vehiculo no fue encontrado con la patente mencionada");
        }
    }

    public void socorrerMoto(String patente){
        for (int i = 0; i < listaDeVehiculos.size(); i++) {
            if(listaDeVehiculos.get(i).getPatente().equals(patente)){
                socMoto.socorrer((Moto) listaDeVehiculos.get(i));
                break;
            }
            if (i==listaDeVehiculos.size()-1) System.out.println("El vehiculo no fue encontrado con la patente mencionada");
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
