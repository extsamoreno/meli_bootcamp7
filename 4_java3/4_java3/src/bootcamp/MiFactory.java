package bootcamp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Properties prop = new Properties();
        prop.load( new FileReader(objName));
        Class s = Class.forName(prop.getProperty("sorter"));
        Object a = s.newInstance();
//        printClassName(s);
//        System.out.println(s.toString());
        return a;
    }

    public static void printClassName(Object s) {
        System.out.println("The class of " + s +
                " is " + s.getClass().getName());
    }
}
