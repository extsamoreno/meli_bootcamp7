package com.company.CT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws IOException {

        Properties properties = new Properties();
        Object obj=null;
        properties.load(new BufferedReader(new FileReader(objName)));

        String object = String.valueOf(properties.getProperty("sorter"));
        String ruta="/Users/lurrea/Documents/Bootcamp/meli_bootcamp7/4_java3/Clase_3/src/com/company/CT/"+object;
        System.out.println(ruta);
        try {
            obj = (Object) Class.forName(ruta);
        } catch (Exception ex) {
            System.out.println("Ingreso"+ex);
        }
        return obj;
    }

}
