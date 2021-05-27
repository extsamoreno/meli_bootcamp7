package Ejercicio5;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(30,11,2021);
        System.out.println(Fecha.isCorrectDate(fecha));

        GregorianCalendar fecha2 = fecha.addDay();
        System.out.println(fecha2.getTime());
    }
}
