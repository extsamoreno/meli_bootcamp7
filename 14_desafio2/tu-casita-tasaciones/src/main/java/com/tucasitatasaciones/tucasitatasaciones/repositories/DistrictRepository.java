package com.tucasitatasaciones.tucasitatasaciones.repositories;

import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DistrictRepository implements IDistrictRepository {

    private HashMap<Integer, District> districtHashMap;

    public DistrictRepository() {
        this.districtHashMap = new HashMap<>();

        this.districtHashMap.put(1, new District(1, "Lugones", 100D));
        this.districtHashMap.put(2, new District(2, "Centro", 100D));
        this.districtHashMap.put(3, new District(3, "General Paz", 100D));
    }

    @Override
    public HashMap<Integer, District> findAll() {
        return null;
    }
}
