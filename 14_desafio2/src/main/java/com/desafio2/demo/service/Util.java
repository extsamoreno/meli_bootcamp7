package com.desafio2.demo.service;

import com.desafio2.demo.dtos.EnvironmentDTO;
import com.desafio2.demo.model.Environment;
import com.desafio2.demo.model.District;
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

public class Util {
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
        PrintWriter writerDistrict = null;

        try {
            writerProperty = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json"));
            writerDistrict = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        assert writerProperty != null;
        writerProperty.print("[]");
        assert writerDistrict != null;
        writerDistrict.print("[]");
        writerProperty.close();
        writerDistrict.close();
    }



    public static District getDistrictPriceTest(String name) {
        District district = new District();
        int id = 1;
        Double price = 100.00;
        district.setId(id);
        district.setName(name);
        district.setPrice(price);
        return district;
    }



}
