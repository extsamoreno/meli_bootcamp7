package com.meli;

public class Main {

            public static void main(String[] args) {

                Carrera carrera = new Carrera();
                carrera.setCantidadDeVehiculosPermitidos(2);
                carrera.darDeAltaAuto(340, 18, 12, "ASD123");
                carrera.darDeAltaMoto(280, 35, 12, "ASD321");
                carrera.darDeAltaAuto(340, 18, 12, "DSA123");
                System.out.println(carrera.definirGanador().getPatente());
                SocorristaMoto socorristaMoto = new SocorristaMoto();
                SocorristaAuto socorristaAuto = new SocorristaAuto();
                carrera.setSocorristaAuto(socorristaAuto);
                carrera.setSocorristaMoto(socorristaMoto);
                carrera.socorrerAuto("ASD123");
                carrera.socorrerMoto("ASD321");
                Moto moto = new Moto(280, 35, 12, "ASD321");
                carrera.eliminarVehiculo(moto);
                carrera.eliminarVehiculoConPatente("ASD123");
            }
        }