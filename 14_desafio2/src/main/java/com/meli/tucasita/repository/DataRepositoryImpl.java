package com.meli.tucasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

@Repository
public class DataRepositoryImpl implements DataRepository {

  private Map<Integer, District> districts = loadDistrictDataBase();
  private Map<Integer, Property> properties = loadPropertyDataBase();

  // ---------------------------- MÉTODOS DE BBDD ----------------------------

  // --- FIND ALL ---- //
  @Override
  public Map<Integer, Property> findAllProperties() {return properties;}

  @Override
  public Map<Integer, District> findAllDistricts() {return districts;}

  // --- FIND BY ID ---- //
  @Override
  public Property findPropertyById(int id) {return properties.get(id);}

  @Override
  public District findDistrictById(int id) {return districts.get(id);}

  // ---------------------------- CARGA DE DE JSON ----------------------------

  private HashMap<Integer, District> loadDistrictDataBase() {
    File file = null;
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    TypeReference<List<District>> typeRef = new TypeReference<>() {};
    List<District> allDistricts = null;
    try {
      file = ResourceUtils.getFile("./src/main/resources/static/districts.json");
      allDistricts = objectMapper.readValue(file, typeRef);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Failed while initializing DB, check your resources files");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Failed while initializing DB, check your JSON formatting.");
    }

    HashMap<Integer, District> districtData = new HashMap<>();
    for (District d: allDistricts) {
      districtData.put(d.getId(), d);
    }
    return districtData;
  }

  private HashMap<Integer, Property> loadPropertyDataBase() {
    File file = null;
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    TypeReference<List<Property>> typeRef = new TypeReference<>() {};
    List<Property> allProperties = null;
    try {
      file = ResourceUtils.getFile("./src/main/resources/static/properties.json");
      allProperties = objectMapper.readValue(file, typeRef);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Failed while initializing DB, check your resources files");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Failed while initializing DB, check your JSON formatting.");
    }

    HashMap<Integer, Property> propertyData = new HashMap<>();
    for (Property p: allProperties) {
      propertyData.put(p.getId(), p);
    }
    return propertyData;
  }
}

