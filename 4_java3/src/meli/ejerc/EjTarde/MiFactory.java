package meli.ejerc.EjTarde;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {

    private static String propFileName = "src/meli/ejerc/EjTarde/MiFactory.properties";

    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String myClassName = myProperties().getProperty(objName);
        Class<?> myClass = Class.forName(myClassName);
        return myClass.getDeclaredConstructor().newInstance();
    }

    private static Properties myProperties() throws IOException {
        Properties prop = new Properties();
        FileReader reader = new FileReader(propFileName);
        prop.load(reader);
        return prop;
    }
}
