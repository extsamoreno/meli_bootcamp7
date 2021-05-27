package com.company;

import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int año;
    private GregorianCalendar calendar;

    public Fecha() {
        calendar=new GregorianCalendar();
    }

    public Fecha(int dia, int mes, int año){
        calendar=new GregorianCalendar();
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        setCalendar();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia){
        this.dia = dia;
        setCalendar();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes){
        this.mes = mes;
        setCalendar();
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año){
        this.año = año;
        setCalendar();
    }

    public void setFecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        setCalendar();
    }

    @Override
    public String toString() {
        return dia+"-"+mes+"-"+ año;
    }

    public String calentarString(){
        int tempDay=calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int tempMonth=calendar.get(GregorianCalendar.MONTH)+1;
        int tempYear=calendar.get(GregorianCalendar.YEAR);
        return tempDay+"-"+tempMonth+"-"+ tempYear;
    }

    public void setCalendar() {
        if (dia>0 && mes>0 && año>0) {
            calendar.set(GregorianCalendar.YEAR, año);
            calendar.set(GregorianCalendar.MONTH, mes-1);
            calendar.set(GregorianCalendar.DAY_OF_MONTH, dia);
        }
    }

    public void forward() throws Exception {
        if(checkCorr()){
            calendar.roll(GregorianCalendar.DAY_OF_MONTH,1);
            int tempDay=calendar.get(GregorianCalendar.DAY_OF_MONTH);
            if(tempDay<dia){
                calendar.roll(GregorianCalendar.MONTH,1);
                int tempMonth=calendar.get(GregorianCalendar.MONTH);
                if(tempMonth<mes-1){
                    calendar.roll(GregorianCalendar.YEAR,1);
                    int tempYear=calendar.get(GregorianCalendar.YEAR);
                    setAño(tempYear);
                }
                setMes(tempMonth+1);
            }
            setDia(tempDay);
        }else{
            throw new Exception("Uno o mas valores de la fecha son incorrectos");
        }
    }

    public boolean checkCorr(){
        boolean valid=true;
        int tempDay=calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int tempMonth=calendar.get(GregorianCalendar.MONTH)+1;
        int tempYear=calendar.get(GregorianCalendar.YEAR);
        if (tempDay!=dia || tempMonth!=mes || tempYear!=año){
            valid=false;
        }
        return valid;
    }
}
