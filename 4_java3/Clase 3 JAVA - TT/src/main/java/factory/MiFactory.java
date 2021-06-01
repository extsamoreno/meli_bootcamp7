package factory;

import java.io.FileReader;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) {
        try{
            FileReader reader = new FileReader("MiFactory.properties");

            Properties p = new Properties();
            p.load(reader);

            return Class.forName(p.getProperty(objName)).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
