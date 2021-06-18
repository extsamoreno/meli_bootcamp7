package com.example.demo;

import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Initializer implements InitializingBean {

    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    DistrictRepository districtRepository;
    /**
     * to automatically initialize the databases
     * */
    @Override
    public void afterPropertiesSet() {
        System.out.println("*******************************");
        System.out.println("**** INITIALIZING DATABASE ****");
        districtRepository.loadData();
        propertyRepository.loadData();
        System.out.println("*******************************");
        System.out.println("********* COMPLETED ***********");
    }
}