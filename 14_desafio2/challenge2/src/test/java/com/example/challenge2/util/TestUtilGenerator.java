package com.example.challenge2.util;

import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
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
            writerProperty = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/property.json"));
            writerNeighborhood = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/district.json"));
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

    public static Property getProperty() {
        Property property = new Property();
        property.setName("Propiedad1");
        property.setDistrictName("Carrasco");
        Environment env1 = new Environment("Cuarto1",8.0,3.0);
        Environment env2 = new Environment("Cuarto2",3.5,9.5);

        List<Environment> environments = new ArrayList<>();
        environments.add(env1);
        environments.add(env2);
        property.setEnvironmentList(environments);
        return property;
    }

    public static void appendNewDistrict(District district) {
        mapper = (ObjectWriter) new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE +
                    "/resources/district.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE +
                    "/resources/district.json"));

            try {
                String studentAsString = mapper.writeValueAsString(district);
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
