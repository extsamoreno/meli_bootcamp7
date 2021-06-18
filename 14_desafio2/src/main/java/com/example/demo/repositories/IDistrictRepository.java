package com.example.demo.repositories;

import com.example.demo.entities.District;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;

@Repository
public interface IDistrictRepository {
    public List<District> loadDistrict();
    public void saveDistrict();
    District findDistrictByName(String districtName) throws FileNotFoundException;
}
