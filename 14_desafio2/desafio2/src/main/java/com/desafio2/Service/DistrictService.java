package com.desafio2.Service;

import com.desafio2.Model.District;
import com.desafio2.Repository.IDistrctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    IDistrctRepository iDistrctRepository;

    @Override
    public void create(District district) {
        iDistrctRepository.save(district);
    }
}
