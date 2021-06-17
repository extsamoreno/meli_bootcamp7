package com.desafio2.demo.util;

import com.desafio2.demo.dtos.ResponseEnvironmentDTO;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.model.Property;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestUtilGenerator {
    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyFiles() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writerProperty = null;
        PrintWriter writerNeighborhood = null;

        try {
            writerProperty = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));
            writerNeighborhood = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/neighborhoods.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        assert writerProperty != null;
        writerProperty.print("[]");
        assert writerNeighborhood != null;
        writerNeighborhood.print("[]");
        writerProperty.close();
        writerNeighborhood.close();
    }

    public static Property getPropertyWith305SquareMeters(String name) {
        Environment environment1 = new Environment("Habitación 1", 45.0, 35.0);
        Environment environment2 = new Environment("Habitación 2", 45.0, 35.0);
        Environment environment3 = new Environment("Habitación 3", 45.0, 35.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        Property property = new Property();
        int id = 10;
        String address = "Calle Falsa 123";
        String neighborhood = "Banfield";
        property.setId(id);
        property.setName(name);
        property.setAddress(address);
        property.setNeighborhood(neighborhood);
        property.setEnvironments(environments);

        return property;
    }

    public static Neighborhood getNeighborhoodPriceTen(String name) {
        Neighborhood neighborhood = new Neighborhood();

        int id = 10;
        Double price = 100000.00;

        neighborhood.setId(id);
        neighborhood.setName(name);
        neighborhood.setPrice(price);

        return neighborhood;
    }

    public static Environment getEnvironment264SquareMeters(String name) {
        Environment environment = new Environment(name, 8.0, 33.0);

        Double width = 8.00;
        Double length = 33.00;

        environment.setName(name);
        environment.setWidth(width);
        environment.setLength(length);

        return environment;
    }

    public static List<ResponseEnvironmentDTO> getEnvironmentSquareMetersList(Property property) {
        List<ResponseEnvironmentDTO> list = new ArrayList<>();
        ResponseEnvironmentDTO environment;

        for(Environment env : property.getEnvironments()) {
            environment = new ResponseEnvironmentDTO(env.getName(), env.getLength() * env.getWidth());
            list.add(environment);
        }

        return list;
    }

    public static void appendNewProperty(Property property) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/properties.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));

            try {
                String studentAsString = mapper.writeValueAsString(property);
                writer.print(content.substring(0, content.length()-1));
                if (content.length()>2) writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert writer != null;
        writer.close();
    }
}
