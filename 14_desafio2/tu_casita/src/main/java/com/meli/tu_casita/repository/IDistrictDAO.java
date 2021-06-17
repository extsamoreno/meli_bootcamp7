package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.District;

import java.util.List;

public interface IDistrictDAO {
    void save(District district);

    boolean delete(int id);

    boolean exists(District district);

    District findById(int id);

    District findByName(String name);

    List<District> getDistrictList();

}
