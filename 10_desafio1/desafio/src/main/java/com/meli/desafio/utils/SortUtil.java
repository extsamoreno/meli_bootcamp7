package com.meli.desafio.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class SortUtil {

    public static int sortByDate(Date date1, Date date2){
        LocalDate localDate1 = LocalDate.parse(date1.toString());
        LocalDate localDate2 = LocalDate.parse(date2.toString());
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);
        return 1;
    }
}
