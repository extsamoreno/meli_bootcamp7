package com.example.desafiospring.socialmeli.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * the date of the validated product
 */
public class ValidDate {
    public static boolean validateDate(String strDate)
    {
        if (strDate.trim().equals(""))
        {
            return true;
        }
        else
        {
            SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
            sdformat.setLenient(false);
            try
            {
                Date javaDate = sdformat.parse(strDate);
            }
            catch (ParseException e)
            {
                return false;
            }
            return true;
        }
    }
}
