package com.meli;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) {
        try {
            FileReader reader = new FileReader("/Users/fgmoreno/Documents/it-bootcamp/codes/meli_bootcamp7/4_java3/ejercitacion_t/src/com/meli/MiFactory.properties");
            Properties p = new Properties();
            p.load(reader);
            String className = p.getProperty(objName);

            return Class.forName(className).newInstance();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
