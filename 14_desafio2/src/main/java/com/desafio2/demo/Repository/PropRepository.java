package com.desafio2.demo.Repository;

import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Model.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class PropRepository implements IPropRepository {

    private Set<District> districtData;

    public PropRepository() throws IOException {
       loadData("src/main/resources/districtData.json");
    }

    /*
    * Mapper the json in districtData
    * */
    void loadData(String path) throws IOException {
        Set<District> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(path);
            loadedData = objectMapper.readValue(file, new TypeReference<Set<District>>() {});
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        this.districtData = loadedData;
    }

    @Override
    public District getDistrictByName(String name) throws DistrictNotExistException {
        //Filter by district name and if dont find any throw DistrictNotExistException
        return districtData.stream()
                .filter(district -> district.getName().equals(name))
                .findFirst()
                .orElseThrow(()->  new DistrictNotExistException(name));
    }
}