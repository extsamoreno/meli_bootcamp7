package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws Exception {

        // Abstraccion de la Ruta del archivo
        // ~/Documents/BootCamp/meli_bootcamp7/4_java3/practica2/src/com.company/"+objName
        //File archivoMiFactory = new File(objName);

        // Instancia de Properties que contien la informacion del archivo
        Properties datos = new Properties();

        try {
            // Instancia del "canal de comunicacion" entre File y Properties
            FileInputStream in = new FileInputStream( "src/com/company/"+objName );

            // Abrir el canal, cargar los datos y cerrar el canal
            datos.load(in);
            in.close();

        } catch (FileNotFoundException ex) {
            System.out.println("The file " + objName + " was not found.");
        }

        //
        Class tmp = Class.forName(datos.getProperty("sorter"));

        return tmp.getDeclaredConstructor().newInstance();
    }
}
