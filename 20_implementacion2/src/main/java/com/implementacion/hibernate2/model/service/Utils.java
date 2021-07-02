package com.implementacion.hibernate2.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utils {

    public static Date convertDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = null;
        try {
            newDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
