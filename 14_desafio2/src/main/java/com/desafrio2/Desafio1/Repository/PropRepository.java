package com.desafrio2.Desafio1.Repository;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PropRepository implements IPropRepository {

    private Set<District> districtData;

    public PropRepository(Set<District> districtData) throws IOException {
       loadData();
    }

    void loadData() throws IOException {
        Set<District> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("src/main/resources/districtData.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<District>>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.districtData = loadedData;
    }

    @Override
    public District getDistrictByName(String name) throws DistrictNotExist {
        return districtData.stream()
                .filter(district -> district.getName().equals(name))
                .findFirst()
                .orElseThrow(()->  new DistrictNotExist(name));
    }
}