package com.ejercicioTarde;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.lang.reflect.*;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        FileReader reader = new FileReader("/Users/juochoa/Documents/git repos/meli_bootcamp7/4_java3/src/com/ejercicioTarde/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);
        System.out.println(p.getProperty(objName));

//      Class o = p.getProperty(objName).getClass();
        var o =  Class.forName(p.getProperty(objName)).getDeclaredConstructors()[0].newInstance();
        return o;
    }
}