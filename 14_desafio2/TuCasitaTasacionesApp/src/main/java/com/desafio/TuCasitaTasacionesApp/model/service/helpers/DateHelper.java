package com.desafio.TuCasitaTasacionesApp.model.service.helpers;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }
}
