package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.Environment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnvironmentRepository implements IEnvironmentRepository {
    List<Environment> environments = new ArrayList<>();
    int count = 0;


    @Override
    public Environment addEnvironment(Environment environment) {
        environment.setId(count);
        environments.add(environment);
        return environment;
    }

    @Override
    public List<Environment> getEnvironment() {
        return environments;
    }
}
