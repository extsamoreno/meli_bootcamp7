import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName){
        Properties propiedades = new Properties();
        Object result = null;
        
        try {
            propiedades.load(new FileReader("MiFactory.properties"));
            result = propiedades.get("sorter");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
