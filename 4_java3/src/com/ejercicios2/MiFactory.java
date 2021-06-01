package com.ejercicios2;

import java.io.FileInputStream;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName){
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream("src/com/ejercicios2/MiFactory.properties");
            Properties p = new Properties();
            p.load(fileStream);
            String className = p.getProperty(objName);
            return Class.forName(className).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
