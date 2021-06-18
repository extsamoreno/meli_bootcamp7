package com.example.demo.repository;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDistrictRepository {
    District findDistrictByName(String name) throws DistrictNotFoundException;
    void addDistrict(District district);
    List<District> getAllDistricts();
}
