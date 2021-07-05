package com.example.demo.repositories;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;

public interface DistrictRepository {
    DistrictRequestDTO createDistrict(DistrictRequestDTO districtRequestDTO);
    void loadData();
    DistrictDTO findDistrictById(int disId) throws DistrictDontFoundException;
}
