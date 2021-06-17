package com.example.demo.services;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.services.dtos.DistrictDTO;
import com.example.demo.services.dtos.DistrictRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImple implements DistrictService{

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public DistrictRequestDTO createDistrict(DistrictRequestDTO districtRequestDTO) {
        return districtRepository.createDistrict(districtRequestDTO);
    }

    @Override
    public DistrictDTO findDistrictById(int distId) throws DistrictDontFoundException {
        return districtRepository.findDistrictById(distId);
    }
}
