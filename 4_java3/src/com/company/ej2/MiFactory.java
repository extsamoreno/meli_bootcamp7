package com.company.ej2;

import java.io.FileReader;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws ClassNotFoundException {
        Properties propHandler = new Properties();
        try{
            propHandler.load(new FileReader("src/parteII/MiFactory.properties"));
            String prop = propHandler.getProperty(objName);
            System.out.println(prop);

            Sorter c = (Sorter) Class.forName(prop).getConstructor().newInstance();
            System.out.println(c.getClass());

            return c;
        }
        catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }
}
