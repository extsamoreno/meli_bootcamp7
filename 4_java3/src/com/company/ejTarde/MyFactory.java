package com.company.ejTarde;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory {

    public static Object getInstance(String objName) {

        String nameClass = "";

        try {

            FileReader reader = new FileReader(objName);

            Properties p = new Properties();
            p.load(reader);

            nameClass = p.getProperty("sorter");

            Class<?> className = Class.forName(nameClass);
            Constructor<?> ctor = className.getConstructor();

            return ctor.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return new Object();
    }

}
