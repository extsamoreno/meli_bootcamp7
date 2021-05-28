import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar calendar = new GregorianCalendar();

    public Fecha (int dia, int mes, int anio) {
        this.calendar.set(anio,mes,dia);
    }
    public Fecha () {}

    public boolean fechaValida (int dia, int mes, int anio) {
        return (LocalDate.of(anio, mes, dia) != null);
    }

    public boolean sumarDia () {
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
        return (fechaValida(calendar.get(GregorianCalendar.DAY_OF_MONTH),
                calendar.get(GregorianCalendar.MONTH),
                calendar.get(GregorianCalendar.YEAR)));
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "calendar=" + calendar +
                '}';
    }
}


/*Crea una clase Fecha. La clase contendrá además de los constructores que consideres adecuados, métodos de acceso
y el método toString, tal como lo explicamos en el ejercicio anterior, un método para comprobar si la fecha es correcta
 y otro para sumarle un día al valor actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar para
  implementar los métodos y constructores de Fecha.
 */
