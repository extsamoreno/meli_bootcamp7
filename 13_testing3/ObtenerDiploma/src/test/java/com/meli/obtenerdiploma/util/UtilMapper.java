package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashSet;
import java.util.Set;

public class UtilMapper {

    static ObjectMapper mapper = new ObjectMapper();

    public static <T> String toJson(T object) throws JsonProcessingException {
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        return writer.writeValueAsString(object);
    }

    public static <T> T fromJson(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        return mapper.readValue(payloadJson, oClass);
    }

    public static <T> Set<T> fromJsonToSet(String payloadJson, Class<T> oClass) throws JsonProcessingException {
        return mapper.readValue(payloadJson, mapper.getTypeFactory().constructCollectionType(HashSet.class, oClass));
    }

}
