import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
            System.out.println( "escribi bien gil!");
        }
        
    }
}
