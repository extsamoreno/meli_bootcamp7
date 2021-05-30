package PracticaTarde;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance (String objName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties p = new Properties();

        try {
            p.load(new FileInputStream("/Users/lvictoria/Desktop/practica1/meli_bootcamp7/4_java3/src/PracticaTarde/" + objName));

        } catch (Exception e) {
            System.out.println("error de archivo");
        }
        Class sorter = Class.forName(p.getProperty("sorter"));
        return sorter.getDeclaredConstructor().newInstance();

    }

}
