import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha
{
    static Calendar fecha = new GregorianCalendar();

    static int year = fecha.get(Calendar.YEAR);
    static int month = fecha.get(Calendar.MONTH) + 1;
    static int day = fecha.get(Calendar.DAY_OF_MONTH);

    public static void main (String[] args)
    {
        validateDate(35,05,2021);
    }

    //region Methods
    public static boolean validateDate(int Day, int Month, int Year)
    {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(Year, Month, Day, 0, 0, 0);

        try{
            Date.getTime();
            System.out.println("Date is valid");
            return true;
        }catch (Exception e){
            System.out.println("Date is invalid please try again");
            return false;
        }
    }

    public static void nextDay()
    {
        fecha.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(fecha);
    }

    public String toString()
    {
        return "";
    }

    //endregion
}
