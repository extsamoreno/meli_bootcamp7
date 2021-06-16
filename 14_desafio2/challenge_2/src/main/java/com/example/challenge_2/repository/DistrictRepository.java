package com.example.challenge_2.repository;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DistrictRepository implements IDistrictRepository {

    private HashMap<String, District> district;

    public DistrictRepository() {
        this.district = new HashMap<>();
        this.district.put("Centro", new District("Centro", 10d));
        this.district.put("Aguada", new District("Aguada", 15d));
        this.district.put("Carrasco", new District("Carrasco", 30d));
        this.district.put("Pocitos", new District("Pocitos", 20d));

    }

    @Override
    public District getByName(String name) throws DistrictNotFoundException {
        District district = this.district.get(name);

        if (district == null){
            throw new DistrictNotFoundException(name);
        }

        return district;
    }
}
