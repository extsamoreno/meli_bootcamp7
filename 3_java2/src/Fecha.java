import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.GregorianCalendar;


public class Fecha {
    private int day;
    private int month;
    private int year;


    public Fecha(int day, int month, int year) {

        if (validate(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            System.out.println("day = " + day);
        }
    }

    public void addDay(int daystobeadded){
        GregorianCalendar calendar = new GregorianCalendar(this.year, this.month, this.day);
        calendar.add(GregorianCalendar.DAY_OF_MONTH,daystobeadded);

        System.out.println("calendar.toString() = " + calendar.toString());
    }

    public boolean validate(int day, int month, int year){
        
        try {
            LocalDate ld = LocalDate.of( year , month , day) ;
            System.out.println("todo OK");
            return true ;  // true = Valid data entered for a date.
        } catch ( DateTimeException e ) {
            System.out.println("mal dia ");
            return false;  // Exception caught, meaning invalid data-entry.
        } finally {
            System.out.println( "Finally!");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Fecha:" + day +
                "/" + month +
                "/" + year ;
    }
}
