package com.example.ApiSpring2.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EdadService {
    public static int obtenerAnios(int dia, int mes, int anio) {
        try {
            if(validateDate(dia,mes,anio)) {
                Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(dia + "/" + mes + "/" + anio);
                Calendar a = getCalendar(birthdate);
                Calendar b = getCalendar(new Date());
                int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
                if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                                a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                    --diff;
                }
                return diff;
            }
            return -1;
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            return -1;
        }

    }
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

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
