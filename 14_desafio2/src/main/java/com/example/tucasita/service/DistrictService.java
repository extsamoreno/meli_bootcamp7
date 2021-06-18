package com.example.tucasita.service;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface DistrictService {
    ResponseDTO addOneDistrict(DistrictDTO district);
    //Set<DistrictDTO> getAllDistricts();
}
