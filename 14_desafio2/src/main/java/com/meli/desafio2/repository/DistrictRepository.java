package com.meli.desafio2.repository;

import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DistrictRepository implements IDistrictRepository {

    // List with all districts
    List<District> districts;

    public DistrictRepository() {

        districts = loadDistricts();
    }

    // Find a district by ID
    @Override
    public District getDistrictbyId(Integer distId) {
        return districts.stream().filter(i -> i.getId().equals(distId)).findFirst().get();
    }

    // Load default districts
    private List<District> loadDistricts(){

        List<District> defaultDistricts = new ArrayList<>();
        defaultDistricts.add(new District(0, "District 1", 150.0));
        defaultDistricts.add(new District(1, "District 2", 180.0));
        defaultDistricts.add(new District(2, "District 3", 200.0));
        defaultDistricts.add(new District(3, "District 4", 250.0));

        return defaultDistricts;
    }
}
