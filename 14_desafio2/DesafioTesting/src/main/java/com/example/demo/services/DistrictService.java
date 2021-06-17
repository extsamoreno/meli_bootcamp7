package com.example.demo.services;


import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.services.dtos.DistrictDTO;
import com.example.demo.services.dtos.DistrictRequestDTO;

public interface DistrictService {
    DistrictRequestDTO createDistrict(DistrictRequestDTO districtRequestDTO);
    DistrictDTO findDistrictById(int distId) throws DistrictDontFoundException;
}
