package com.bootcamp;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    int dia;
    int mes;
    int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha() {
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

    public boolean isCorrect() {
        try {
            LocalDate.of( this.anio , this.mes , this.dia );
        } catch (DateTimeException ex) {
            return false;
        }
        return true;
    }

    public void nextDay() {
        GregorianCalendar calendar = new GregorianCalendar(this.anio, this.mes - 1, this.dia);
        calendar.add(Calendar.DATE, 1);

        this.anio = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH) + 1;
        this.dia = calendar.get(Calendar.DATE);
    }

    @Override
    public String toString() {
        return "Fecha{" +
                +dia + "/" + mes + "/" + anio +
                '}';
    }
}
