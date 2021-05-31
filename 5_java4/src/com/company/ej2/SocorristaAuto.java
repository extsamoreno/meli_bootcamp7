package com.company.ej2;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Vehiculo v) {

        if(v instanceof Auto) {
            System.out.println("Socorriendo Auto con patente : " + v.getPatente());
        } else {
            System.out.println("SOCORRO AUTO - No se puede socorrer, ya que no es un auto o no se encuentra en" +
                    "la carrera.");
        }

    }

}
