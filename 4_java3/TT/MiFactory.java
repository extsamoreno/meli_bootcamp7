import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException {
        FileReader reader = new FileReader
                ("/Users/Desktop/BootCamplautaro/meli_bootcamp7/4_java3/TT/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);

        Class o = p.getProperty(objName).getClass();
        Class o2 = Class.forName(p.getProperty("sorter").getClass().getName());

        return o;
    }
}
