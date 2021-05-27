package com.company.ej5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        GregorianCalendar gc = new GregorianCalendar();
        this.dia = gc.get(Calendar.DAY_OF_MONTH);
        this.mes = gc.get(Calendar.MONTH);
        this.anio = gc.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anio) {
        GregorianCalendar gc = new GregorianCalendar(anio, mes, dia);
        this.dia = gc.get(Calendar.DAY_OF_MONTH);
        this.mes = gc.get(Calendar.MONTH);
        this.anio = gc.get(Calendar.YEAR);
    }

    public static boolean isCorrectDate(int dia, int mes, int anio) {

        GregorianCalendar gc = new GregorianCalendar(anio, mes, 1);
        int maxDay = 0;

        if(anio < 1) {
            return false;
        }

        if(mes > 12 || mes < 1) {
            return false;
        }

        maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDay);
        
        if(dia > maxDay) {
            return false;
        }

        return true;

    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
