package com.desafio2.Utils;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.District;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class TestUtils {

    private static String SCOPE;
    //private static ObjectWriter mapper;

    public static void emptyFile(String fileName) {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/" + fileName));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static Property createProperty(String name) {
        Environment environment1 = new Environment("Room1", 6.0, 10.0);
        Environment environment2 = new Environment("Room2", 8.0, 11.0);
        Environment environment3 = new Environment("Room3", 5.0, 8.0);

        List<Environment> environmentList = new ArrayList<>();
        environmentList.add(environment1);
        environmentList.add(environment2);
        environmentList.add(environment3);

        return new Property(name,"Center", environmentList);
    }


    public static Environment createEnvironment() {
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        return new Environment("Room" + randomInt, 6.7, 10.5);
    }


    public static District createWestDistrict100USD() {
        return new District("West", 100);
    }

    public static List<EnvironmentDTO> getEnvironments() {
        EnvironmentDTO environment1 = new EnvironmentDTO("Room1", 60);
        EnvironmentDTO environment2 = new EnvironmentDTO("Room2", 88);
        EnvironmentDTO environment3 = new EnvironmentDTO("Room3", 40);

        List<EnvironmentDTO> environmentList = new ArrayList<>();
        environmentList.add(environment1);
        environmentList.add(environment2);
        environmentList.add(environment3);

        return environmentList;
    }
}
