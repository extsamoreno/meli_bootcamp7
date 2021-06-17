package com.desafiotesting.api.repository;

import com.desafiotesting.api.model.District;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DistrictsRepository implements IDistrictsRepository {

    private static Map<String, District> districts = new HashMap<>();
    static {
        District district1 = new District("Barrio Norte", 40.0);
        District district2 = new District("Centro", 100.0);
        District district3 = new District("Residencial", 80.0);

        districts.put("Barrio Norte", district1);
        districts.put("Centro", district2);
        districts.put("Residencial", district3);

    }

    @Override
    public Map<String, District> getDistricts() {return districts;}

//    @Override
//    public void setDistricts(Map<String, District> districts) {
//        DistrictsRepository.districts = districts;
//    }

}
