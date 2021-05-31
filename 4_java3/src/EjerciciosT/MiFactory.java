package EjerciciosT;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws ClassNotFoundException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Properties prop = new Properties();
        FileReader reader = new FileReader("src/EjerciciosT/MiFactory.properties");
        prop.load(reader);

        String className = prop.getProperty(objName);
        //System.out.println(objName + " " + className);

        Class<?> myClass = Class.forName(className);
        return myClass.getDeclaredConstructor().newInstance();

    }
}
