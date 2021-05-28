package com.company.CT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws IOException {

        Properties properties = new Properties();
        Object obj =null;
        properties.load(new BufferedReader(new FileReader(objName)));
        String object = String.valueOf(properties.getProperty("sorter"));
        System.out.println(object);
        try {
             obj = Class.forName(object).newInstance();
        } catch (Exception ex) {
            //Hacer algo
        }
        return obj;
    }

}
