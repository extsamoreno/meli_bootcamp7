import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private GregorianCalendar fecha;

    public Fecha(int dia, int mes, int anio) {
        try {
            this.fecha = new GregorianCalendar(anio, mes, dia);
        } catch (Exception exception) {
            System.out.println("La fecha ingresada es invalida");
        }
    }

    public void sumarDia(int diasASumar) {
        this.fecha.add(Calendar.DATE, diasASumar);
    }

    public Fecha() {
    }

    public int getDia() {
        return this.fecha.get(Calendar.DATE);
    }

    public int getMes() {
        return this.fecha.get(Calendar.MONTH) + 1;
    }

    public int getAnio() {
        return this.fecha.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return this.getDia() + "/" + this.getMes() +
                "/" + this.getAnio();
    }

}
