package com.meli.claseSpring2.web.services;

import org.apache.tomcat.jni.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EdadService {
    public static int calcularEdad(int dia, int mes, int anio){
        LocalDate lt = LocalDate.now();
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        Period diff = Period.between(fecha,lt);
        return diff.getYears();
    }
}
