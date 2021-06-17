package com.example.demo.repositories;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.model.District;
import com.example.demo.services.dtos.DistrictDTO;
import com.example.demo.services.dtos.DistrictRequestDTO;

public interface DistrictRepository {
    DistrictRequestDTO createDistrict(DistrictRequestDTO districtRequestDTO);
    void loadData();
    DistrictDTO findDistrictById(int disId) throws DistrictDontFoundException;

}
