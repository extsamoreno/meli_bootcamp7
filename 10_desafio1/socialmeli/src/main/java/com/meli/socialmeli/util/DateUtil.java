package com.meli.socialmeli.util;

import java.time.LocalDate;

public class DateUtil {
    public static boolean dateBeforeDate(LocalDate date, LocalDate dateToCompared) {
        return date.isBefore(dateToCompared);
    }
}
