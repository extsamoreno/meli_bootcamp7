package com.example.challenge_2.service;

import com.example.challenge_2.exception.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    //ValueOne can't be greater than value two
    public static void validateDoubleGreaterThanValue(double valueOne, double valueTwo, String fieldOne, String fieldTwo) throws ValueDoubleOneCantBeGreaterThanValueTwoException {
        if(valueOne > valueTwo) {
            throw new ValueDoubleOneCantBeGreaterThanValueTwoException(fieldOne, fieldTwo);
        }
    }

    public static void startWithUpperCase(String stringToTest, String fieldName) throws StringDontStartWithUpperCaseException {
        char firstChar = stringToTest.charAt(0);
        char firstCharUpper = stringToTest.toUpperCase().charAt(0);
        if(firstChar != firstCharUpper) {
            throw new StringDontStartWithUpperCaseException(fieldName);
        }
    }

    public static void maximunLength(String stringToTest, String fieldName, int maxLength) throws MaximunLengthExceededException {
        if(stringToTest.length() > maxLength) {
            throw new MaximunLengthExceededException(fieldName);
        }
    }
}
