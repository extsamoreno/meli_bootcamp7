//Crea una clase Fecha. La clase contendrá además de los constructores que consideres
// adecuados, métodos de acceso y el método toString, tal como lo explicamos en el ejercicio
// anterior, un método para comprobar si la fecha es correcta y otro para sumarle
// un día al valor actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar
// para implementar los métodos y constructores de Fecha.

package ejercicios;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar calendar = new GregorianCalendar();

    public Fecha(int day, int month, int year) {
        if (validate(day, month, year)){
            calendar.set(year, month, day);
        }else{
            System.out.println("day = " + day);
        }
    }

    @Override
    public String toString(){
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        Integer month = calendar.get(Calendar.MONTH);
        Integer year = calendar.get(Calendar.YEAR);
        return (day.toString() +"/"+ month.toString()+"/"+year.toString());
    }

    public void addDay(int daystobeadded){
        calendar.add(GregorianCalendar.DAY_OF_MONTH,daystobeadded);
    }

    public boolean validate(int day, int month, int year){
        
        try {
            LocalDate ld = LocalDate.of( year , month , day) ;
            return true ;  // true = Valid data entered for a date.
        } catch ( DateTimeException e ) {
            return false;  // Exception caught, meaning invalid data-entry.
        } finally {
            System.out.println( "fecha incorrecta");
        }
        
    }

}
