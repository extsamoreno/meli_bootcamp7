package com.company;
import java.util.GregorianCalendar;

public class Fecha {
    int dia;
    int mes;
    int ano;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int ano) {

        if (isValid(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isValid() {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(this.ano, this.mes-1, this.dia);
        try{
            Date.getTime();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void addDay() {
        if (this.isValid()) {
            GregorianCalendar Date = new GregorianCalendar();
            Date.setLenient(false);
            Date.set(this.ano, this.mes-1, this.dia);
            Date.add(GregorianCalendar.DAY_OF_MONTH, 1);

            this.dia = Date.get(GregorianCalendar.DAY_OF_MONTH);
            this.mes = Date.get(GregorianCalendar.MONTH) + 1;
            this.ano = Date.get(GregorianCalendar.YEAR);
        }
    }

    public static boolean isValid(int dia, int mes, int ano) {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(ano, mes-1, dia);
        try{
            Date.getTime();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Fecha: " + dia + "/" + mes + "/" +ano;
    }
}
