package tt;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/"+objName));
            Class<?> clase = Class.forName(properties.getProperty("sorter"));
            return clase.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
