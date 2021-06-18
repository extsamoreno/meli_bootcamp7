package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository implements IDistrictRepository {
    List<District> districts = new ArrayList<>();
    int cont = 0;

    @Override
    public District addDistrict(District district) {
        district.setId(cont++);
        districts.add(district);
        return district;
    }
}
