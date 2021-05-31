import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties prop= readPropertiesFile("/Users/mirivera/Documents/meli_bootcamp7/4_java3/src/MiFactory.properties");
        System.out.println(prop.getProperty("sorter").substring(prop.getProperty("sorter").indexOf(".")+1));
        Class<?> clazz= Class.forName(prop.getProperty("sorter").substring(prop.getProperty("sorter").indexOf(".")+1));
        Object object= clazz.newInstance();
        return object;
    }

    private static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis=null;
        Properties prop=null;
        try {
            fis= new FileInputStream(fileName);
            prop= new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
