package com.desafio2.Repository;

import com.desafio2.Exception.DistrctNotFoundException;
import com.desafio2.Model.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class DistrictRepository implements IDistrctRepository {

    private String SCOPE;

    private Set<District> districts;

    public DistrictRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(District district) {
        boolean ret = false;

        try {
            ret  = this.findByName(district.getDistrict_name()) != null;
        }
        catch (DistrctNotFoundException e) {}

        return ret;
    }

    @Override
    public District findByName(String name) {
        loadData();
        return districts.stream()
                .filter(dis -> dis.getDistrict_name().equals(name))
                .findFirst()
                .orElseThrow(() -> new DistrctNotFoundException(name));
    }

    private void loadData() {
        Set<District> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<District>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.districts = loadedData;
    }
}
