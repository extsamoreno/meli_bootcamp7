package com.company.Clase2JavaTM;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    int dia,mes,año;
    private Calendar calendar;

    public Fecha(int dia, int mes, int año) {

        this.calendar = new GregorianCalendar(año, mes, dia);
        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }

    public void mostrarFecha(){
        System.out.println("Fecha ingresada: ");
        int m = this.calendar.get(calendar.MONTH);
        String sMes="";
        switch (m){
            case 0: sMes="Enero";break;
            case 1: sMes="Febrero";break;
            case 2: sMes="Marzo";break;
            case 3: sMes="Abril";break;
            case 4: sMes="Mayo";break;
            case 5: sMes="Junio";break;
            case 6: sMes="Julio";break;
            case 7: sMes="Agosto";break;
            case 8: sMes="Septiembre";break;
            case 9: sMes="Octubre";break;
            case 10: sMes="Noviembre";break;
            case 11: sMes="Diciembre";break;
        }
        System.out.println(this.calendar.get(Calendar.DATE)+"/"+sMes+"/"+
                this.calendar.get(Calendar.YEAR));

    }

    public void sumarDia(){

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Dia sumado a la fecha");
        mostrarFecha();
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + año +
                '}';
    }

    public static void main(String[] args) {
        Fecha fecha = new Fecha(31,11,2021);
        fecha.mostrarFecha();
        fecha.sumarDia();

    }

}
