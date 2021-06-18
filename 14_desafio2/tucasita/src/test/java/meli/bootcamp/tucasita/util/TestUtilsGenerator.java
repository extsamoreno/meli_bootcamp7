package meli.bootcamp.tucasita.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.model.Environment;
import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.service.dto.DistrictDTO;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    public static void emptyPropertyFile() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/database/property.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        writer.print("[]");
        writer.close();
    }

    public static void emptyDistrictFile() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/database/district.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        writer.print("[]");
        writer.close();
    }

    public static PropertyDTO getPropertyDTOWith3Environments(String name) {
        Environment environment1 = new Environment("Sala",15.0,13.0);
        Environment environment2 = new Environment("Comedor",25.0,20.3);
        Environment environment3 = new Environment("Patio",15.0,13.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        DistrictDTO districtDTO= getDistrictDto(null);
        return new PropertyDTO(name,districtDTO,environments);
    }

    public static Property getPropertyWith3Environments(String name) {
        Environment environment1 = new Environment("Sala",15.0,13.0);
        Environment environment2 = new Environment("Comedor",25.0,20.3);
        Environment environment3 = new Environment("Patio",15.0,13.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        District district= getDistrict(null);
        return new Property(name,district,environments);
    }

    public static Property getPropertyWith3EnvironmentsAndDistricName(String name,String districtName) {
        Environment environment1 = new Environment("Sala",15.0,13.0);
        Environment environment2 = new Environment("Comedor",25.0,20.3);
        Environment environment3 = new Environment("Patio",15.0,13.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(environment1);
        environments.add(environment2);
        environments.add(environment3);

        District district= getDistrict(districtName);
        return new Property(name,district,environments);
    }



    public static DistrictDTO getDistrictDto(String name) {
        if(name==null){
            return new DistrictDTO("District test",500);
        }
        return new DistrictDTO(name,1500);
    }

    public static District getDistrict(String name) {
        if(name==null){
            return new District("District test",500);
        }
        return new District(name,1500);
    }

    public static Set<Property> getPropertySet() {
        Property property = getPropertyWith3Environments("Casa Marco");
        Property property1 = getPropertyWith3Environments("Casa Polo");
        Property property2 = getPropertyWith3EnvironmentsAndDistricName("Casa Julio", "Puertas del Sol");
        Property property3 = getPropertyWith3EnvironmentsAndDistricName("Casa Cesar", "Tibabuyes");
        return new HashSet<Property>(){{add(property); add(property1); add(property2); add(property3);}};
    }

    public static void appendNewProperty(Property property) {
        mapper =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/database/property.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/database/property.json"));

            try {
                String propertyAsString = mapper.writeValueAsString(property);
                writer.print(content.substring(0, content.length()-1));
                if (content.length()>2) writer.print(", ");
                writer.print(propertyAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();
    }

}

