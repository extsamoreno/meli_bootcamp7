import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Fecha {
    private Calendar fecha;
    private Locale locale;
    private SimpleDateFormat formatOfDate;

    public Fecha() {
        this.fecha = GregorianCalendar.getInstance();
        this.locale = Locale.getDefault();
        this.formatOfDate = new SimpleDateFormat("dd-MM-yyyy");
        this.formatOfDate.setLenient(false);
    }

    public Fecha(String fecha) {
        this.fecha = GregorianCalendar.getInstance();
        this.locale = Locale.getDefault();
        this.formatOfDate = new SimpleDateFormat("dd-MM-yyyy");
        this.formatOfDate.setLenient(false);
        try {
            this.fecha.setTime(formatOfDate.parse(fecha));
        } catch (ParseException e) {
            this.fecha = GregorianCalendar.getInstance();

        }

    }

    @Override
    public String toString() {
        return "La fecha es: " + this.fecha.get(Calendar.DAY_OF_MONTH) + " de "
                + this.fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, this.locale) + " del año "
                + this.fecha.get(Calendar.YEAR);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar sumar() {
        this.fecha.add(Calendar.DAY_OF_MONTH, 1);
        return this.fecha;
    }

    public Boolean validar(String fecha) {

        try {
            formatOfDate.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

}