package com.company.ejercicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.GregorianCalendar;


public class Fecha {

    private LocalDate localDate;


    public Fecha(LocalDate localDate){

        this.localDate = localDate;
    }

    public Fecha(){

    }

    @Override
    public String toString() {
        return "Fecha{" +
                "localDate=" + localDate +
                '}';
    }

    public boolean esCorrecta(Fecha fecha){
        if(GregorianCalendar.getInstance().toString().equals(fecha.toString())){
            return true;
        } else {
            return false;
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

}
