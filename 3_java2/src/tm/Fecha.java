package tm;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Fecha {

    private Calendar fecha;

    public Fecha() {
        this.fecha = new GregorianCalendar(TimeZone.getTimeZone("GMT-5"));
    }

    public Fecha(int dia, int mes, int anio) {
        this.fecha = new GregorianCalendar(anio, mes, dia);
    }

    public boolean comprobarFecha(int dia, int mes, int anio) {
        Fecha fechaComparar = new Fecha(dia, mes, anio);
        Fecha fechaActual = new Fecha();
        return fechaComparar.getFecha().before(fechaActual.getFecha());
    }

    public Fecha sumarDiaFechaActual(int numeroDias) {

        Fecha fechaActual = new Fecha();
        fechaActual.getFecha().add(Calendar.DATE, numeroDias);

        return fechaActual;
    }


    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\"" + fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) + "\"";
    }

}
