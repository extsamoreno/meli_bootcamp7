package com.meli;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        String string = "ola Hola Hola";
        int posicion = StringUtil.indexOfN(string, 'o', 4);

        System.out.println("posicion = " + posicion);
    }
}
