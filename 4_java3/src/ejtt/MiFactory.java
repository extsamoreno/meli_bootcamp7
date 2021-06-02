package ejtt;

import java.util.Properties;
import java.io.FileReader;

public class MiFactory {
  public static Object getInstance(String objName) throws Exception{
        // create a reader object on the properties file
        FileReader reader = new FileReader("MiFactory.properties");
        // create properties object
        Properties p = new Properties();
        // add a wrapper around reader object (si no, null)
        p.load(reader);
        // access properties data
        String value = p.getProperty(objName);
      try {
        return Class.forName(value).getDeclaredConstructor().newInstance();

      } catch (ClassNotFoundException e) {
        throw e;
      }
  }}
