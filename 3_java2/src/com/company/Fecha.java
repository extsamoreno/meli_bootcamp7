package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private Calendar fecha;

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Fecha() {
        this.fecha = new GregorianCalendar();
    }

    public Fecha(int day, int month, int year) {
        this.fecha = new GregorianCalendar(year, month, day);
    }

    public void validate() {
        this.fecha.setLenient(false); //Habilitamos el chequeo de errores
        try {
            this.fecha.get(Calendar.DATE);
            this.fecha.get(Calendar.MONTH);
            this.fecha.get(Calendar.YEAR);
            //Si intentamos obtener campos que no son validos, va a romper
        } catch (IllegalArgumentException e) { //Exception que tira si tenemos algun valor mal
            System.out.println(e);
            throw e;
        }

        this.fecha.setLenient(true); //Si no partio, ponemos true
    }

    public void addDay() {
        try {
            int day = this.fecha.get(Calendar.DATE) + 1;
            int month = this.fecha.get(Calendar.MONTH);
            int year = this.fecha.get(Calendar.YEAR);
            this.fecha = new GregorianCalendar(year, month, day);
            validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/", fecha.get(Calendar.DATE)) + String.format("%d/", fecha.get(Calendar.MONTH)) + String.format("%d", fecha.get(Calendar.YEAR));
    }
}
