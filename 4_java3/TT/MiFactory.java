import paquete.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        FileReader reader = new FileReader
                ("/Users/lpozzolo/IdeaProjects/BootCampLautaro/src/MiFactory.properties");
        Properties p = new Properties();
        p.load(reader);

        String property = p.getProperty(objName);
        //Class o2 = Class.forName(p.getProperty("sorter").getClass().getName());

        Class o = Class.forName(property);
        Constructor c = o.getConstructor();

        return c.newInstance();
    }
}
