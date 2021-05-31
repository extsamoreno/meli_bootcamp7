package com.ejercicioMañana;

import java.util.GregorianCalendar;
import java.util.Calendar;

//Crea una clase Fecha. La clase contendrá además de los constructores que consideres adecuados, métodos de acceso y el método toString, tal como lo explicamos en el ejercicio anterior, un método para comprobar si la fecha es correcta y otro para sumarle un día al valor actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar para implementar los métodos y constructores de Fecha.
public class Fecha {
    GregorianCalendar fechaGreg;

    public int getDia(){
        return fechaGreg.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes(){
        return fechaGreg.get(Calendar.MONTH) + 1;
    }

    public int getAño(){
        return fechaGreg.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int año) {
        this.fechaGreg = new GregorianCalendar(año,mes-1,dia);
    }

    public void sumarDia(){
        fechaGreg.add(Calendar.DAY_OF_MONTH, 1);
    }

    public boolean isCorrectDate(int dia, int mes, int año){
        var testCalendar = new GregorianCalendar(año,mes-1,dia);
        return testCalendar.get(Calendar.DAY_OF_MONTH) == dia && testCalendar.get(Calendar.MONTH)+1 == mes && testCalendar.get(Calendar.YEAR) == año;
    }

    @Override
    public String toString() {
        return "Fecha{"+getDia()+'/'+getMes()+'/'+getAño()+'}';
    }
}
