package com.meli;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private String fecha;
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" +
                calendar.get(Calendar.YEAR) + "";
    }

    public Fecha(int dia, int mes, int anio) {
        GregorianCalendar calendar = new GregorianCalendar(anio, (mes - 1), dia);
        if (esCorrecta(dia, mes, anio)){
            this.dia = calendar.get(Calendar.DATE);
            this.mes = calendar.get(Calendar.MONTH) + 1;
            this.anio = calendar.get(Calendar.YEAR);
            this.fecha = this.dia + "/" + this.mes + "/" + this.anio;
        } else {
            this.fecha = null;
        }
    }

    public boolean esCorrecta(int dia, int mes, int anio) {
        GregorianCalendar calendar = new GregorianCalendar(anio, (mes - 1), dia);
        if (calendar.get(Calendar.DATE) == dia && calendar.get(Calendar.MONTH) == (mes - 1) &&
                calendar.get(Calendar.YEAR) == anio){
            return true;
        } else {
            return false;
        }
    }

    public void sumarDia(int dias) {
        GregorianCalendar calendar = new GregorianCalendar(this.anio, (this.mes - 1), this.dia);

        calendar.add(Calendar.DATE, dias);
        System.out.println("calendar.get(Calendar.DATE) = " + calendar.get(Calendar.DATE));
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));
        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        this.dia = calendar.get(Calendar.DATE);
        this.mes = calendar.get(Calendar.MONTH) + 1;
        this.anio = calendar.get(Calendar.YEAR);
        this.fecha = this.dia + "/" + this.mes + "/" + this.anio;
    }

    public String getFecha() {
        return fecha;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "fecha='" + fecha + '\'' +
                '}';
    }
}
