package com.meli.desafio2.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.model.dto.EnvironmentDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtilGenerator {
    static ObjectMapper mapper = new ObjectMapper();

    public static Property getProperty(){
        Property property = new Property();
        District district = new District(1, "Jardin Aeropuerto", 300.5);
        Environment env1 = new Environment("Baño", 5,7);
        Environment env2 = new Environment("Habitacion 1", 5,8);
        Environment env3 = new Environment("Cocina", 8,7);

        List<Environment> environments = Arrays.asList(env1,env2,env3);

        property.setProp_name("Casa del Barba");
        property.setDistrict(district);
        property.setEnvironmentList(environments);

        return property;
    }

    public static List<EnvironmentDTO> environmentDTOList(){
        EnvironmentDTO env1 = new EnvironmentDTO("Baño", 35);
        EnvironmentDTO env2 = new EnvironmentDTO("Habitacion 1", 40);
        EnvironmentDTO env3 = new EnvironmentDTO("Cocina", 56);

        return Arrays.asList(env1, env2, env3);
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