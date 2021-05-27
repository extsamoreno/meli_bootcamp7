package com.meli;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Fecha fecha = new Fecha();
        System.out.println("fecha = " + fecha);

        fecha.sumarDia(20);
        System.out.println("fecha = " + fecha);
    }
}
