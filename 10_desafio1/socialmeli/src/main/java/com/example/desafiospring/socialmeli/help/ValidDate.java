package com.example.desafiospring.socialmeli.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidDate {
    public static boolean validateDate(String strDate)
    {
        if (strDate.trim().equals(""))
        {
            return true;
        }
        else
        {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
            sdfrmt.setLenient(false);
            try
            {
                Date javaDate = sdfrmt.parse(strDate);
            }
            catch (ParseException e)
            {
                return false;
            }
            return true;
        }
    }
}
