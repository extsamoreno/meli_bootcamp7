package com.meli.tucasita.repository;

import com.meli.tucasita.models.District;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistrictRepository {

    District getDistrictByName(String name);

    boolean districtNameNotExists(String name);

    void loadData();

    void saveDataIntoJson();

}
