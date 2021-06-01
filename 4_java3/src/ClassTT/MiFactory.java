package ClassTT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.FileHandler;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Properties pr = new Properties();
        pr.load(new FileInputStream("MiFactory.properties"));
        Class temp = Class.forName(pr.getProperty("sorter"));
        return temp.getDeclaredConstructor().newInstance();
    }
}
