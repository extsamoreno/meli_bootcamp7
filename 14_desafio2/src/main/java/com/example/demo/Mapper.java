package com.example.demo;

import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<Environment> toEnvironment(List<EnvironmentDTO> environments) {
        List<Environment> result = new ArrayList<>();
        for (EnvironmentDTO environmentDTO : environments) {
            Environment environment = new Environment();
            environment.setName(environmentDTO.getName());
            environment.setLength(environmentDTO.getLength());
            environment.setWidth(environmentDTO.getWidth());

            result.add(environment);
        }
        return result;
    }
}
