package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.Environment;

import java.util.List;

public interface IEnvironmentRepository {
    Environment addEnvironment(Environment environment);

    List<Environment> getEnvironment();
}
