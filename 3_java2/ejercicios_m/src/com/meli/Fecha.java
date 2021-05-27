package com.meli;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Fecha {
    private Calendar fecha;

    public Fecha() {
        this.fecha = new GregorianCalendar(TimeZone.getTimeZone("GMT-3"));
    }


}
