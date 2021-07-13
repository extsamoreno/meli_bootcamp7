package com.example.dentaloffice.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TurnUtils {

    public static Date toDate(String dateDto)
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(dateDto);
        }
        catch (ParseException ex){
            ex.printStackTrace();
        }
        return date;
    }
}
