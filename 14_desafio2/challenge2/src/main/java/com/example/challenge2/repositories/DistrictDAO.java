package com.example.challenge2.repositories;

import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class DistrictDAO implements IDistrictDAO{
    private String SCOPE;
    Set<District> districts;


    @Override
    public District save(District district) throws DistrictNotFoundException{

        this.delete(district.getName());
        districts.add(district);
        this.saveData();
        return district;

    }
    public boolean delete(String districtName) {
        boolean ret = false;

        try {
            District found = this.findByName(districtName);

            districts.remove(found);
            ret  = true;
            this.saveData();

        } catch (DistrictNotFoundException e) {}

        return ret;
    }

    @Override
    public District findByName(String districtName) throws DistrictNotFoundException {
        loadData();
        District res =  districts.stream().filter(district -> district.getName().equals(districtName)).findFirst().get();
        if (res != null)
            return res;
        else
            throw new DistrictNotFoundException(districtName);
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/district.json");
            objectMapper.writeValue(file, this.districts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }


    private void loadData() {
        Set<District> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/district.json");
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
