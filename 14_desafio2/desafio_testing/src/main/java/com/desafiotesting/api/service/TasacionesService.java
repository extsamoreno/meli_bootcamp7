package com.desafiotesting.api.service;

import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.exception.NotFoundDistrictException;
import com.desafiotesting.api.repository.IDistrictsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasacionesService implements ITasacionesService{
    @Autowired
    IDistrictsRepository repository;

    @Override //US 0001: Get total area of a house
    public TotalAreaDTO totalArea(PropertyDTO house){
        List<EnvironmentDTO>environments=house.getEnvironments();
        double total=0.0;
        for (int i = 0; i < environments.size(); i++) {
            double currentArea = environments.get(i).getLength()*environments.get(i).getWidth();
            total=total+currentArea;
        }
        TotalAreaDTO response = new TotalAreaDTO(house.getName(),total);
        return response;
    }

    @Override //US 0002: Get price of a house
    public PriceDTO price(PropertyDTO house) throws NotFoundDistrictException {
        List<EnvironmentDTO>environments=house.getEnvironments();
        String districtName = house.getDistrict();

        if(repository.getDistricts().get(districtName)==null){ throw new NotFoundDistrictException();}

        double districtPrice = repository.getDistricts().get(districtName).getPrice();
        double total=0.0;
        for (int i = 0; i < environments.size(); i++) {
            double currentArea = environments.get(i).getLength()*environments.get(i).getWidth();
            total=total+currentArea;
        }
        PriceDTO response = new PriceDTO(house.getName(),total*districtPrice);
        return response;
    }

    @Override //US 0003: Get bigger environment of a house
    public BiggerEnvironmentDTO biggerEnvironment(PropertyDTO house){
        List<EnvironmentDTO>environments=house.getEnvironments();
        double max=0.0;
        String environmentName = null;
        for (int i = 0; i < environments.size(); i++) {
            double currentArea = environments.get(i).getLength()*environments.get(i).getWidth();
            if(currentArea>max){
                environmentName=environments.get(i).getName();
            }
        }
        BiggerEnvironmentDTO response = new BiggerEnvironmentDTO(environmentName);
        return response;
    }

    @Override //US 0004: Get each environment area of a house
    public ArrayList<EnvironmentAreaDTO> environmentsArea(PropertyDTO house){

        List<EnvironmentDTO>environments=house.getEnvironments();
        ArrayList<EnvironmentAreaDTO> response = new ArrayList<>();

        for (int i = 0; i < environments.size(); i++) {
            double currentArea = environments.get(i).getLength()*environments.get(i).getWidth();
            String currentName = environments.get(i).getName();
            EnvironmentAreaDTO environment = new EnvironmentAreaDTO(currentName,currentArea);
            response.add(environment);
        }
        return response;
    }








}
