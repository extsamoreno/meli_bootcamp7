package Parte1.Fecha;

import Parte1.Fecha.Fecha;

public class Main {

    public static void main(String[] args) {
        Fecha fecha = new Fecha(32, 03, 2001);
        System.out.println(fecha);
        fecha.incrementDay();
        System.out.println(fecha);
    }
}
