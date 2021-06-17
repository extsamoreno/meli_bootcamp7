package com.example.challenge2.repository;

import com.example.challenge2.models.District;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DistrictRepository implements IDistrictRepository {

    private static Map<String, District> district = new HashMap<>();
    static {
        District district1 = new District("LasCondes", 20.0);
        District district2 = new District("SantiagoCentro", 100.0);
        District district3 = new District("Ñuñoa", 60.0);

        district.put("LasCondes", district1);
        district.put("SantiagoCentro", district2);
        district.put("Ñuñoa", district3);


    }

    @Override
    public Map<String, District> getDistricts() {
        return null;
    }

    @Override
    public void setDistricts(Map<String, District> districts) {

    }
}
