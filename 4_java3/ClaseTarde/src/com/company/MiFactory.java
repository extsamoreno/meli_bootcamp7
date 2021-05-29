package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException {
        FileReader reader = new FileReader("/Users/alesta/Documents/it-bootcamp/codes/meli_bootcamp7/4_java3/ClaseTarde/src/com/meli/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);
        System.out.println(p.getProperty("sorter"));

//        Class o = p.getProperty(objName).getClass();
        Class<?> o = Class.forName(p.getProperty("sorter"));
        return o;
    }
}
