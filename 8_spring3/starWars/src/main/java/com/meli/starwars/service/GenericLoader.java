package com.meli.starwars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class GenericLoader<T> {
    public <T> T loadData(String pathToFile) {
        try {
            File file = ResourceUtils.getFile(pathToFile);
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<T> typeRef = new TypeReference<>() {
            };
            return objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
