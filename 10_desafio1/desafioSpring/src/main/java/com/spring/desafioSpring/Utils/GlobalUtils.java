package com.spring.desafioSpring.Utils;

import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import org.apache.tomcat.util.security.Escape;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GlobalUtils {

    public static String getProperty(String key) throws PropertyNotFoundException {
        Properties properties = new Properties();
        String value = null;

        try {
            properties.load(new FileReader( ResourceUtils.getFile("classpath:application.properties")));
            value = properties.getProperty(key);
        } catch (IOException e) {
            throw new PropertyNotFoundException(key);
        } catch(Exception ex){
            throw new PropertyNotFoundException(key);
        }



        if(value == null)
            throw new PropertyNotFoundException(key);

        return value;
    }

}
