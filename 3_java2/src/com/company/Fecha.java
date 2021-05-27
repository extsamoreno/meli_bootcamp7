package com.company;

import java.util.GregorianCalendar;

public class Fecha {
    // Crea una clase Fecha. La clase contendrá además de los constructores que consideres adecuados,
    // métodos de acceso y el método toString, tal como lo explicamos en el ejercicio anterior,
    // un método para comprobar si la fecha es correcta y otro para sumarle un día al valor actual de la fecha.
    // Se debe investigar y utilizar la clase GregorianCalendar para implementar los métodos y constructores de Fecha.
    private int day;
    private int month;
    private int year;

    public void esCorrecta() {
        GregorianCalendar gc = new GregorianCalendar(year, month, day);

    }

    public void agregarDia() {

    }

    public Fecha() {
    }

    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
