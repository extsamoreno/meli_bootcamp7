package com.ejercitacion.mañana;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar fecha;

    public Fecha() {
        this.fecha = new GregorianCalendar();
    }

    public boolean check() {
        this.fecha.setLenient(false);
        try {
            this.fecha.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Fecha(int day, int month, int year) throws Exception {
        if (month >= 1 && month <= 12) {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day < 1 || day > 30) {
                    throw new Exception("Invalid date");
                } else {
                    this.fecha = new GregorianCalendar(year, month, day);
                }
            } else if (month == 2) {
                    if (day < 1 || day > 29) {
                        throw new Exception("Invalid date");
                    } else {
                        this.fecha = new GregorianCalendar(year, month, day);
                    }
                } else {
                if (day < 1 || day > 31) {
                    throw new Exception("Invalid date");
                } else {
                    this.fecha = new GregorianCalendar(year, month, day);
                }
            }
        } else {
            throw new Exception("Invalid date");
        }
    }

    public void agregarDia() {
        this.fecha.add(Calendar.DATE, 1);
    }

    @Override
    public String toString() {
        return this.fecha.toString();
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
