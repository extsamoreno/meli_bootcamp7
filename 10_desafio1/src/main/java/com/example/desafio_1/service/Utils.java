package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Utils {
    public static void validateStringEmpty(String string, String fieldName) throws EmptyStringException {
        if (string.isEmpty()) {
            throw new EmptyStringException(fieldName);
        }
    }

    public static void validateIntGreaterThanZero(int integer, String fieldName) throws NumberNotGreaterThanZero {
        if (integer <= 0) {
            throw new NumberNotGreaterThanZero(fieldName);
        }
    }

    public static void validateDoubleGreaterThanZero(double value, String fieldName) throws NumberNotGreaterThanZero {
        if (value <= 0) {
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

    public static int[] getAllKeysFromFollowing(HashMap<Integer, Seller> hashMap) {
        return hashMap.keySet().stream().flatMapToInt(x -> IntStream.of(Integer.parseInt(x.toString()))).toArray();
    }

    public static Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }

    public static void validateBooleanMustBeTrue(boolean booleanToTest, String field) throws WrongValueInFieldException {
        if (!booleanToTest) { //if is not true, throw excpetion
            throw new WrongValueInFieldException(field, "true");
        }
    }


    //ValueOne can't be greater than value two
    public static void validateDoubleGreaterThanValue(double valueOne, double valueTwo, String fieldOne, String fieldTwo) throws ValueDoubleOneCantBeGreaterThanValueTwoException {
        if(valueOne > valueTwo) {
            throw new ValueDoubleOneCantBeGreaterThanValueTwoException(fieldOne, fieldTwo);
        }
    }

    //ValueOne can't be equals to value two
    public static void validateDoubleEqualsToValue(double valueOne, double valueTwo, String fieldOne, String fieldTwo) throws ValueDoubleOneCantBeGreaterThanValueTwoException, ValueDoubleOneCantBeEqualsToValueTwoException {
        if(valueOne == valueTwo) {
            throw new ValueDoubleOneCantBeEqualsToValueTwoException(fieldOne, fieldTwo);
        }
    }
}
