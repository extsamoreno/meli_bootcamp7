package meli.ejerc.Ej5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(){
        GregorianCalendar gc = new GregorianCalendar();
        this.dia = gc.get(Calendar.DAY_OF_MONTH);
        this.mes = gc.get(Calendar.MONTH);
        this.anio = gc.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anio) throws Exception {
        if (isValidDate(dia, mes, anio)) {
            GregorianCalendar gc = new GregorianCalendar(anio, mes, dia);
            this.dia = gc.get(Calendar.DAY_OF_MONTH);
            this.mes = gc.get(Calendar.MONTH);
            this.anio = gc.get(Calendar.YEAR);
        }
        else
        {
            throw new Exception("Date format not valid");
        }
    }

    public static boolean isValidDate(int dia, int mes, int anio) {
        GregorianCalendar gc = new GregorianCalendar(anio, mes, dia);
        boolean resultado = anio >= 1;
        if (mes < 0 || mes > 11) {
            resultado = false;
        }
        int maxDay = gc.getMaximum(Calendar.DAY_OF_MONTH);
        if (dia > maxDay) resultado = false;
        return resultado;
    }

    @Override
    public String toString() {
        return "Fecha = " +
                dia +
                "/" + (mes+1) +
                "/" + anio;
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
}
