package ejcio2_dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private float distancia, premioEnDolares;
    private String nombre;
    private short cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(float distancia, float premioEnDolares, String nombre, short cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) throws Exception {
        boolean result = false;
        for (Vehiculo v : vehiculos) {
            if (v.equals(vehiculo)) {
                result = true;
                break;
            }
        }
        if (result) {
            vehiculos.remove(vehiculo);
        } else
            throw new Exception("No hay ningún vehículo que coincida con los datos ingresados");
    }

    public void eliminarVehiculoConPatente(String patente) throws Exception {
        boolean result = false;
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                result = true;
                break;
            }
        }
        if (result) {
            vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        } else {
            throw new Exception("No hay ningún vehículo que coincida con los datos ingresados");
        }
    }

    public Vehiculo definirGanador(List<Vehiculo> vehiculos) {

        Vehiculo vehiculoGanador = null;
        double maxValor = 0;

        for (Vehiculo v : vehiculos) {
            double thisValor = obtenerPerformance(v);
            if (thisValor > maxValor) {
                vehiculoGanador = v;
            }
        }
        return vehiculoGanador;
    }

    private double obtenerPerformance(Vehiculo v) {
        return v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }

    // Getters & Setters
    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(float premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(short cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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
