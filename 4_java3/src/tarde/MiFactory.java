package tarde;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName){
        Properties propiedades = new Properties();

        try {
            propiedades.load(new FileReader(
                    "/Users/ntosi/Documents/Bootcamp/repoBootcamp/meli_bootcamp7/4_java3/src/tarde/MiFactory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String classToReturn = propiedades.getProperty(objName);

        Class c = null;
        Object obj = null;

        try {
            c = Class.forName(classToReturn);
            obj = (Object) c.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
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

        return obj;
    }

}

       /* //leer todas las keys
        Enumeration<Object> claves = propiedades.keys();
        while (claves.hasMoreElements()) {
        Object clave = claves.nextElement();
        System.out.println(clave.toString() + " - " + propiedades.get(clave).toString());
        }
       */
