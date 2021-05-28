package com.meli;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException {
        FileReader reader = new FileReader("/Users/fgmoreno/Documents/it-bootcamp/codes/meli_bootcamp7/4_java3/ejercitacion_t/src/com/meli/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);

        Class o = p.getProperty(objName).getClass();
//        Class o = Class.forName(p.getProperty("sorter").getClass().getName());
        return o;
    }
}
