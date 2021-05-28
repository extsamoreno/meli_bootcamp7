package ejercicio_tarde;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName){
        Properties properties = new Properties();
        Object sorter = null;
        try {
            properties.load(new FileReader("MiFactory.properties"));
            String property = properties.getProperty("sorter");
            sorter = Class.forName(property).getConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    return sorter;
    }
}
