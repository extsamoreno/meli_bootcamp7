package com.meli.tucasitatasaciones.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.model.District;
import com.meli.tucasitatasaciones.model.Environment;
import com.meli.tucasitatasaciones.model.Property;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {
    static ObjectMapper mapper = new ObjectMapper();

    public static Property getProperty() {
        Environment env1 = new Environment("Habitacion 1",6.0,5.0);
        Environment env2 = new Environment("Habitacion 2",4.0,2.5);

        List<Environment> environments = new ArrayList<>();
        environments.add(env1);
        environments.add(env2);

        Property property = new Property();
        property.setName("Casa 1");
        property.setDistrict(new District("Alto Alberdi",250.0));
        property.setEnvironments(environments);
        return property;
    }

    public static PropertyDTO getPropertyDTO(String districtName) {
        EnvironmentDTO env1 = new EnvironmentDTO("Habitacion 1",6.0,5.0);
        EnvironmentDTO env2 = new EnvironmentDTO("Habitacion 2",4.0,2.5);

        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(env1);
        environments.add(env2);

        PropertyDTO property = new PropertyDTO();
        property.setName("Casa 1");
        property.setDistrictName(districtName);
        property.setEnvironments(environments);
        return property;
    }

    public static List<PropertyDTO> getPropertiesDTO() {
        PropertyDTO prop1 = getPropertyDTO("D1");
        PropertyDTO prop2 = getPropertyDTO("D1");
        PropertyDTO prop3 = getPropertyDTO("D1");

        List<PropertyDTO> properties = new ArrayList<>();
        properties.add(prop1);
        properties.add(prop2);
        properties.add(prop3);

        return properties;
    }

    public static List<Property> getProperties() {
        Property prop1 = getProperty();
        Property prop2 = getProperty();
        Property prop3 = getProperty();

        List<Property> properties = new ArrayList<>();
        properties.add(prop1);
        properties.add(prop2);
        properties.add(prop3);

        return properties;
    }

    public static List<EnvironmentDTO> getEnvironmentsDTO() {
        EnvironmentDTO env1 = new EnvironmentDTO("Habitacion 1",30.0);
        EnvironmentDTO env2 = new EnvironmentDTO("Habitacion 2",10.0);

        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(env1);
        environments.add(env2);

        return environments;
    }

    public static EnvironmentDTO toEnvironmentDTO(Environment env) {
        EnvironmentDTO environmentDTO = new EnvironmentDTO();
        environmentDTO.setName(env.getName());
        environmentDTO.setLength(env.getLength());
        environmentDTO.setWidth(env.getWidth());
        return environmentDTO;
    }

    public static <T> String toJson(T object) throws JsonProcessingException {
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false). writer().withDefaultPrettyPrinter();
        return writer.writeValueAsString(object);
    }

    public static <T> T fromJson(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        return mapper.readValue(payloadJson, oClass);
    }

    public static <T> List<T> fromJsonToList(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        new ObjectMapper();
        return mapper.readValue(payloadJson, mapper.getTypeFactory().constructCollectionType(ArrayList.class, oClass));
    }
}
