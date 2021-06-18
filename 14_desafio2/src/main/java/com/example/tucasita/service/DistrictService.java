package com.example.tucasita.service;

import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface DistrictService {
    ResponseDTO addOneDistrict(DistrictDTO districtDTO);
}
