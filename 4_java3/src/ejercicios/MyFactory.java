package ejercicios;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory {
    public static Object getInstance(String objName){
        Object sorter =null;
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("MiFactory.properties"));
            String property = properties.getProperty("sorter");
            sorter = Class.forName(property).getConstructor().newInstance();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return sorter;
    }
}
