package com.bootcamp;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName)  {

        Properties appProps = getProperties();

        Class clazz;
        Constructor ctor;
        Object object = null;

        try {
            clazz = Class.forName(appProps.getProperty("sorter"));
            ctor = clazz.getConstructor();
            object = ctor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;
    }

    private static Properties getProperties() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String miFactoryPath = rootPath + "MiFactory.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(miFactoryPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appProps;
    }


}
