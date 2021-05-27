package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public boolean esCorrecta(){
     return true;
    }

    public String sumarDia(){
        GregorianCalendar calendar = new GregorianCalendar(this.año, this.mes, this.dia);
        calendar.add(Calendar.DATE, 1);
        this.dia = calendar.get(Calendar.DATE);
        this.mes = calendar.get(Calendar.MONTH);
        this.año = calendar.get(Calendar.YEAR);

        return this.toString();
    }
    @Override
    public String toString(){
        return this.dia + "/" + this.mes + "/" + this.año;
    }
}
