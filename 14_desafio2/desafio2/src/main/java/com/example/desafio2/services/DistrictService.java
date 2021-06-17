package com.example.desafio2.services;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.repositories.IDistrictRepository;
import com.example.desafio2.services.mappers.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService{
    @Autowired
    IDistrictRepository iDistrictRepository;

    @Override
    public int add(DistrictDTO district) {
        return iDistrictRepository.add(DistrictMapper.toModel(district));
    }
}
