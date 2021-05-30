package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        try {
            //Leemos el archivo por la propiedad
            FileReader reader = new FileReader("/Users/gloprete/meli_bootcamp7/4_java3/src/com/company/MiFactory.properties");

            // Creamos un objeto properties
            Properties properties = new Properties();

            // Cargamos el objeto properties con lo que leimos del archivo
            properties.load(reader);

            String className = properties.get("sorter").toString();

            Class<?> classFromFile = Class.forName(className);
            Constructor<?> ctor = classFromFile.getConstructor();
            return ctor.newInstance(new Object[] { });

        } catch (Exception e) {
            throw e;
        }
    }

}
