package Parte2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName){
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("src/Parte2/MiFactory.properties"));
            String proper = properties.getProperty(objName);
            Sorter c = (Sorter) Class.forName(proper).getConstructor().newInstance();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
