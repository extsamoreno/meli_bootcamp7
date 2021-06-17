package com.example.challenge_2.service;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;
import com.example.challenge_2.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService {

    @Autowired
    IDistrictRepository districtRepository;

    @Override
    public District getDistrictByName(String name) throws DistrictNotFoundException {
        return districtRepository.getByName(name);
    }
}
