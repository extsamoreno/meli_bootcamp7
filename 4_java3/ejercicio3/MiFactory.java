package ejercicio3;

import java.io.FileInputStream;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("MiFactory.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String className = properties.getProperty(objName);

            return Class.forName(className).newInstance();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("No se ha podido ordenar");
        }
    }
}