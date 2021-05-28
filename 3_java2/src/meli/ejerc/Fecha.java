package meli.ejerc;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private Calendar fecha;

    public Fecha() {
        this.fecha = new GregorianCalendar();
    }

    public Fecha(int dia, int mes, int anio) {
        if(esCorrecta(dia, mes, anio)){
            Calendar fechaN = new GregorianCalendar(anio, mes, dia);
            this.fecha = fechaN; //Caso de exito
        }
    }

    public boolean esCorrecta(int dia, int mes, int anio){
        Calendar fechaN = Calendar.getInstance();

        fechaN.set(anio,mes,dia);

        if (fechaN.get(Calendar.DATE) == dia &&
                fechaN.get(Calendar.MONTH)+1 == mes &&
                fechaN.get(Calendar.YEAR) == anio
        ) {
            return true;
        }
        return false;
    }

    public int getDia() {
        return this.fecha.get(Calendar.DATE);
    }

    public void setDia(int dia) {
        this.fecha.set(Calendar.DATE, dia);
    }

    public int getMes() {
        return this.fecha.get(Calendar.MONTH);
    }

    public void setMes() {
        this.fecha.set(Calendar.MONTH, mes);
    }

    public int getAnio() {
        return this.fecha.get(Calendar.YEAR);
    }

    public void setAnio(int anio) {
        this.fecha.set(Calendar.YEAR, anio);
    }

    public void sumarDia() {
        this.fecha.add(Calendar.DATE, 1);
    }

    @Override
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.anio;
    }

}
