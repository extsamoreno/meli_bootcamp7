package com.meli.desafio.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChallengeUtils {

    public static Date stringToDate(String stringDate){
        Integer day = Integer.parseInt(stringDate.substring(0, 2));
        Integer month = Integer.parseInt(stringDate.substring(3, 5));
        Integer year = Integer.parseInt(stringDate.substring(6, 10));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }

    public static String dateToString(Date date ){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public static Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }
}
