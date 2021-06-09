package com.example.desafio_1.service;

import com.example.desafio_1.exception.DateExceptionInvalidFormat;
import com.example.desafio_1.exception.EmptyStringException;
import com.example.desafio_1.exception.NumberNotGreaterThanZero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static void validateStringEmpty(String string, String fieldName) throws EmptyStringException {
        if (string.isEmpty()) {
            throw new EmptyStringException(fieldName);
        }
    }

    public static void validateIntGreaterThanZero(int integer, String fieldName) throws NumberNotGreaterThanZero {
        if (integer < 0) {
            throw new NumberNotGreaterThanZero(fieldName);
        }
    }

    public static void validateDoubleGreaterThanZero(double value, String fieldName) throws NumberNotGreaterThanZero {
        if (value < 0) {
            throw new NumberNotGreaterThanZero(fieldName);
        }
    }

    public static void validateDate(String value, String fieldName) throws DateExceptionInvalidFormat {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(value);
        } catch (ParseException e) {
            throw new DateExceptionInvalidFormat(fieldName);
        }
    }
}
