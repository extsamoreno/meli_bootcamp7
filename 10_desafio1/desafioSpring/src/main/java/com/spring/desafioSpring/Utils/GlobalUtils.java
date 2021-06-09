package com.spring.desafioSpring.Utils;

import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import org.apache.tomcat.util.security.Escape;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GlobalUtils {

    public static String getProperty(String key) throws PropertyNotFoundException {
        Properties propiedades = new Properties();
        String value = null;

        try {
            propiedades.load(new FileReader(
                    "/Users/ntosi/Documents/Bootcamp/repoBootcamp/meli_bootcamp7/10_desafio1/desafioSpring/src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new PropertyNotFoundException(key);
        }

        try {
            value = propiedades.getProperty(key);
        }catch(Exception ex){
            throw new PropertyNotFoundException(key);
        }

        if(value == null)
            throw new PropertyNotFoundException(key);

        return value;
    }

}
