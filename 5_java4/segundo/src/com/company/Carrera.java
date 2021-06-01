package com.company;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private float distancia, premio_dolares;
    private String nombre;
    private short cantidad_vehiculos_permitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(float distancia, float premio_dolares, String nombre, short cantidad_vehiculos_permitidos, SocorristaAuto sauto, SocorristaMoto smoto) {
        this.distancia = distancia;
        this.premio_dolares = premio_dolares;
        this.nombre = nombre;
        this.cantidad_vehiculos_permitidos = cantidad_vehiculos_permitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = sauto;
        this.socorristaMoto = smoto;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPremio_dolares() {
        return premio_dolares;
    }

    public void setPremio_dolares(float premio_dolares) {
        this.premio_dolares = premio_dolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCantidad_vehiculos_permitidos() {
        return cantidad_vehiculos_permitidos;
    }

    public void setCantidad_vehiculos_permitidos(short cantidad_vehiculos_permitidos) {
        this.cantidad_vehiculos_permitidos = cantidad_vehiculos_permitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float angulodegiro, String patente) {
        if (vehiculos.size() < cantidad_vehiculos_permitidos) {
            Auto auto = new Auto(velocidad, aceleracion, angulodegiro, patente);
            vehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(float velocidad, float aceleracion, float angulodegiro, String patente) {
        if (vehiculos.size() < cantidad_vehiculos_permitidos) {
            Moto moto = new Moto(velocidad, aceleracion, angulodegiro, patente);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        vehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
        /*
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                vehiculos.remove(vehiculo);
                break;
            }
        }*/
    }


    public Vehiculo getGanador() throws Exception {
        if (vehiculos.size() > 0) {
            Vehiculo ganador = vehiculos.get(0);
            float puntaje_ganador = calcularPuntaje(ganador);

            for (Vehiculo veh : vehiculos) {
                float puntaje = calcularPuntaje(veh);
                System.out.println(puntaje);
                if (puntaje > puntaje_ganador) {
                    puntaje_ganador = puntaje;
                    ganador = veh;
                }
            }

            return ganador;
        }
        throw new Exception("No hay autos");
    }

    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    private static float calcularPuntaje(Vehiculo v) {
        return (float)(v.getVelocidad() * 0.5 * v.getAccelaracion() / (v.getAngulo_giro()*(v.getPeso()-v.getRuedas()*100)));
    }

    public void socorrerAuto(String patente) throws Exception {
        Vehiculo veh = getVehiculoConPatente(patente);
        if (veh != null && veh instanceof Auto) {
            socorristaAuto.socorrer((Auto)veh);
        } else if (veh == null) {
            throw new Exception("No existe vehiculo con esa patente");
        } else {
            throw new Exception("El auto que intenta socorrer es una Moto");
        }
    }

    public void socorrerMoto(String patente) throws Exception {
        Vehiculo veh = getVehiculoConPatente(patente);
        if (veh != null && veh instanceof Moto) {
            socorristaMoto.socorrer((Moto)veh);
        } else if (veh == null) {
            throw new Exception("No existe vehiculo con esa patente");
        } else {
            throw new Exception("El auto que intenta socorrer es un Auto");
        }
    }

    public Vehiculo getVehiculoConPatente(String unaPatente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                return vehiculo;
            }
        }
        return null;
    }

    public void printVehiculos() {
        for (Vehiculo veh : vehiculos) {
            System.out.println(veh.getPatente());
        }
        System.out.println();
    }


}
