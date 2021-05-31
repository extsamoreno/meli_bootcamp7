package com.company.ej2;

public class SocorristaMoto implements Socorrista {

    @Override
    public void socorrer(Vehiculo v) {

        if(v instanceof Moto) {
            System.out.println("Socorriendo Moto con patente : " + v.getPatente());
        } else {
            System.out.println("SOCORRO MOTO - No se puede socorrer, ya que no es una moto o no se encuentra en" +
                    "la carrera.");
        }

    }

}
