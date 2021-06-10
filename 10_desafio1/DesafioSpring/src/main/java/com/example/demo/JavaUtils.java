package com.example.demo;

import com.example.demo.exceptions.InvalidDateFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class JavaUtils {
    public static int daysDifference(LocalDate now, LocalDate postDate){

        long daysBetween = DAYS.between(postDate, now);
        return (int) daysBetween;
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String dateToString(Date date) throws InvalidDateFormatException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate="";
        try {
             strDate = dateFormat.format(date);
        }catch (Exception e){
            throw new InvalidDateFormatException(strDate);
        }
        return strDate;
    }

    public static Date stringToDate(String sDate) throws ParseException, InvalidDateFormatException {
        Date date;
        try { date = new SimpleDateFormat("dd-MM-yyyy").parse(sDate);
        }catch (Exception e){
            throw new InvalidDateFormatException(sDate);
        }
        return date;
    }
}
