package practicaTM;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private Calendar fecha;

    public Fecha() {
        this.fecha = new GregorianCalendar();
    }

    public Fecha(int dia,int mes, int anio) {
        this.fecha = new GregorianCalendar(anio,mes,dia);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\""+fecha.get(Calendar.DATE)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR)+"\"";
    }
}
