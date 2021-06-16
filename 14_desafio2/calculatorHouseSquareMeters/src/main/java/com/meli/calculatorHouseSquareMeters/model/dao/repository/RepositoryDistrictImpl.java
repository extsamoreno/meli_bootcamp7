package com.meli.calculatorHouseSquareMeters.model.dao.repository;

import com.meli.calculatorHouseSquareMeters.database.DataBaseDistricts;
import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryDistrictImpl implements RepositoryDistrict{
    private final ArrayList<District> dataBaseDistricts = DataBaseDistricts.dataBaseDistricts;

    public District getDistrictByName(String name) {
        District district = null;
        for (District district_: dataBaseDistricts) {
            if (district_.getDistrictName().equals(name)) {
                district = district_;
                break;
            }
        }
        return district;
    }

    public boolean putDistrict(District district) {
        if (!districtExist(district.getDistrictName())) {
            dataBaseDistricts.add(district);
            return true;
        }
        return false;
    }

    private boolean districtExist(String name) {
        boolean exist = false;
        for (District district: dataBaseDistricts) {
            if (district.getDistrictName().equals(name)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
