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

    public String esCorrecta(){

        GregorianCalendar calendar = new GregorianCalendar(this.año, this.mes, this.dia);
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        if( date == this.dia && month == this.mes &&  year== this.año){
            return "La fecha es correcta";
        }
        else{
            return "La fecha no es correcta";
        }
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

    public static void main(String[] args){
        Fecha fecha = new Fecha(-1, 13 , 2021);
        Fecha fecha2 = new Fecha(1, 6, 2022);
        System.out.println(fecha.esCorrecta());
        System.out.println(fecha2.sumarDia());
    }
}
