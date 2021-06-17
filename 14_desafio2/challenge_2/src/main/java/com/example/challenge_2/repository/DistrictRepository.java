package com.example.challenge_2.repository;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Repository
public class DistrictRepository implements IDistrictRepository {

    private HashMap<String, District> districts;

    public DistrictRepository() {
        this.districts = new HashMap<>();
        this.districts.put("Centro", new District("Centro", 10d));
        this.districts.put("Aguada", new District("Aguada", 15d));
        this.districts.put("Carrasco", new District("Carrasco", 30d));
        this.districts.put("Pocitos", new District("Pocitos", 20d));

    }

    @Override
    public District getByName(String name) throws DistrictNotFoundException {
        District district = this.districts.get(name);

        if (district == null){
            throw new DistrictNotFoundException(name);
        }

        return district;
    }
}
