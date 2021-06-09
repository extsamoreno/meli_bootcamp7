package com.example.demo;

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
}
