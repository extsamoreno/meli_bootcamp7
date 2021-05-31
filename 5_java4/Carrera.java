import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    int distancia,premioEnDolares,cantidadVehiculos;
    String nombre;
    List<Vehiculo> vehiculos;

    public Carrera(int distancia, int premioEnDolares, int cantidadVehiculos, String nombre) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.cantidadVehiculos = cantidadVehiculos;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>(cantidadVehiculos);
    }

    public void darDeAltaAuto(String patente, double velocidad, double aceleracion, double anguloDeGiro){
        if(vehiculos.size() != cantidadVehiculos){
            Auto auto = new Auto(patente,velocidad,aceleracion,anguloDeGiro);
            vehiculos.add(auto);
        }else{
            System.out.println("No se puede agregar mas autos a la carrera");
        }
    }

    public void darDeAltaMoto(String patente, double velocidad, double aceleracion, double anguloDeGiro){
        if(vehiculos.size() != cantidadVehiculos){
            Moto moto = new Moto(patente,velocidad,aceleracion,anguloDeGiro);
            vehiculos.add(moto);
        }else{
            System.out.println("No se puede agregar mas motos a la carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        List<Vehiculo> listVehiculos = this.vehiculos.stream().filter(vehiculo ->
                vehiculo.patente.equals(unaPatente)).collect(Collectors.toList());
        //if(listVehiculos.size() > 0){
          //  eliminarVehiculo(listVehiculos.get(0));
        //}else {
          //  System.out.println("No se encontro el vehiculo");
        //}
        try{
            eliminarVehiculo(listVehiculos.get(0));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
