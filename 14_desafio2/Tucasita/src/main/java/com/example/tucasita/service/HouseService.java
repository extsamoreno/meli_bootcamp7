package com.example.tucasita.service;

import com.example.tucasita.repository.IDistrictRepository;
import com.example.tucasita.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseRepository houseRepository;
    @Autowired
    IDistrictRepository districtRepository;

}
