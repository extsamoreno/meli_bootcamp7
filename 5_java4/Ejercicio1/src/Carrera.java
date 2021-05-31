import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Auto con patente " + patente + " se agrego correctamente.");
        }else {
            System.out.println("Cupos en la carreras lleno.");
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (listaVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Moto con patente " + patente + " se agrego correctamente.");
        }else {
            System.out.println("Cupos en la carreras lleno.");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (listaVehiculos.remove(vehiculo) == true) {
            System.out.println("Eliminado exitosamente");
        } else {
            System.out.println("No existe ese vehiculo");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        Integer index = listaVehiculos.size()+1;
        Vehiculo vehiculo = null;
        for (int i = 0; i < listaVehiculos.size()-1 ; i++) {
            if (listaVehiculos.get(i).getPatente().equals(patente))
                vehiculo = listaVehiculos.get(i);
        }
        if (vehiculo != null && listaVehiculos.remove(vehiculo) == true) {
            System.out.println("Eliminado exitosamente");
        } else {
            System.out.println("No existe ese vehiculo");
        }
    }

    public Vehiculo definirGanador (){
        Double mayorCalculo = 0.0;
        Vehiculo vehiculoGanador = null;

        for (Vehiculo vehiculo: listaVehiculos) {
            Double calculo =calcularGanador(vehiculo);
            if (calculo>mayorCalculo){
                mayorCalculo = calculo;
                vehiculoGanador = vehiculo;
            }
        }
        return  vehiculoGanador;
    }

    private double calcularGanador(Vehiculo vehiculo){
        double primeraparte = vehiculo.getPeso()/vehiculo.getRuedas() *100;
        double segundaparte = vehiculo.getAnguloDeGiro()*primeraparte;
        double terceraparte = (vehiculo.getAceleracion()/2)/segundaparte;
        double cuartaparte = vehiculo.getVelocidad()*terceraparte;

        return cuartaparte;
    }


    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
