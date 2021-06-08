package tm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar {

    public Fecha() {
    }

    public Fecha(int year, int month, int day) {
        this.set(year, month, day);
    }

    public void addOneDay() {
        this.add(Calendar.DAY_OF_YEAR, 1);
    }

    @Override
    public String toString() {
        Date d = this.getTime();
        DateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
        return formatter.format(d);
    }
}
