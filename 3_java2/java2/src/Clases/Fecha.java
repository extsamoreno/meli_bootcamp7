package Clases;

import java.util.*;

public class Fecha {


    Calendar calendar;

    public Fecha() {
        
    }

    public Fecha(Date time) {
        validateDate(time);
    }


    public Calendar getCalendar() {
        if(this.calendar==null){
            String [] ids = TimeZone.getAvailableIDs (-5 * 60 * 60 * 1000);
            SimpleTimeZone pdt =new SimpleTimeZone(-5 * 60 * 60 * 1000, ids [0]);
            this.calendar = new GregorianCalendar(pdt);
        }
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }


    public boolean validateDate(Date time){
        try {
            this.calendar=getCalendar();
            calendar.setTime(time);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public void addDay(){
        this.calendar.roll(Calendar.DAY_OF_MONTH,true);
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "calendar=" + calendar.getTime() +
                '}';
    }
}
