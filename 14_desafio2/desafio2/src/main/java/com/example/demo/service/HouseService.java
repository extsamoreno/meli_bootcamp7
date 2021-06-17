package com.example.demo.service;

import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HouseService implements IHouseService {
    private final IDistrictRepository iDistrictRepository;

    public HouseService(IDistrictRepository iDistrictRepository) {
        this.iDistrictRepository = iDistrictRepository;
    }

    @Override
    public double calculateM2(House house) {
        iDistrictRepository.findDistrictByName(house.getDistrict().getDistric_name());
        double totalM2=0;
        for (Environment r:house.getEnvironmentArrayList()){
            totalM2+=calculateM2Environment(r);
        }
        return totalM2;
    }

    @Override
    public double calculateM2Environment(Environment environment) {
        return environment.getEnvironment_length()*environment.getEnvironment_width();
    }

    @Override
    public double calculatePrice(House house) {
        District district = iDistrictRepository.findDistrictByName(house.getDistrict().getDistric_name());
        return calculateM2(house)*district.getDistric_price();
    }

    @Override
    public String biggestEnvironment(House house) {
        District district = iDistrictRepository.findDistrictByName(house.getDistrict().getDistric_name());
        double biggestEnvironment=0;
        String nameEnvironment="";
        for (int i = 0; i < house.getEnvironmentArrayList().size(); i++) {
            Environment environment = house.getEnvironmentArrayList().get(i);
            if (this.calculateM2Environment(environment)>biggestEnvironment){
                biggestEnvironment=this.calculateM2Environment(environment);
                nameEnvironment=environment.getEnvironment_name();
            }
        }
        return "El ambiente más grande es "+nameEnvironment+" con un área de "+biggestEnvironment;
    }

    @Override
    public ArrayList<String> environmentM2(House house) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<house.getEnvironmentArrayList().size();i++) {
            Environment environment = house.getEnvironmentArrayList().get(i);
            double area = this.calculateM2Environment(environment);
            list.add(environment.getEnvironment_name()+" "+area);
        }
        return list;
    }
}
