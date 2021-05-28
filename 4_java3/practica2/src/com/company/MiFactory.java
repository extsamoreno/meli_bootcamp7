package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("src/com/company/"+objName));

        Class tmp = Class.forName(properties.getProperty("sorter"));

        return tmp.getDeclaredConstructor().newInstance();
    }
}
