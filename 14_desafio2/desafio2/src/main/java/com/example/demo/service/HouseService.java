package com.example.demo.service;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingDistrictException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.dto.*;
import com.example.demo.service.mapper.IDistricMapper;
import com.example.demo.service.mapper.IHouseMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class HouseService implements IHouseService {
    private final IDistrictRepository iDistrictRepository;
    private final IHouseRepository iHouseRepository;
    private final IHouseMapper iHouseMapper;
    private final IDistricMapper iDistricMapper;

    public HouseService(IDistrictRepository iDistrictRepository, IHouseRepository iHouseRepository,
                        IHouseMapper iHouseMapper, IDistricMapper iDistricMapper) {
        this.iDistrictRepository = iDistrictRepository;
        this.iHouseRepository = iHouseRepository;
        this.iHouseMapper = iHouseMapper;
        this.iDistricMapper = iDistricMapper;
    }
    @Override
    public double calculateM2(String name) throws HouseNotFoundException, DistrictNotFoundException {
        House house= iHouseRepository.findHouseByName(name);
        iDistrictRepository.findDistrictByName(house.getDistric_name());
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
    public double calculatePrice(String name) throws HouseNotFoundException, DistrictNotFoundException {
        House house= iHouseRepository.findHouseByName(name);
        District district = iDistrictRepository.findDistrictByName(house.getDistric_name());
        return calculateM2(name)*district.getDistric_price();
    }

    @Override
    public String biggestEnvironment(String name) throws HouseNotFoundException, DistrictNotFoundException {
        House house= iHouseRepository.findHouseByName(name);
        District district = iDistrictRepository.findDistrictByName(house.getDistric_name());
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
    public ArrayList<String> environmentM2(String name) throws HouseNotFoundException {
        House house= iHouseRepository.findHouseByName(name);
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<house.getEnvironmentArrayList().size();i++) {
            Environment environment = house.getEnvironmentArrayList().get(i);
            double area = this.calculateM2Environment(environment);
            list.add(environment.getEnvironment_name()+" "+area);
        }
        return list;
    }

    @Override
    public void addHouse(HouseDTO houseDTO) throws DistrictNotFoundException, ExistingHouseException {
        House house = iHouseMapper.houseDTOToHouse(houseDTO);
        String houseName = house.getProp_name();
        iDistrictRepository.findDistrictByName(house.getDistric_name());
        try {
            House house1 = iHouseRepository.findHouseByName(houseName);
            throw new ExistingHouseException(houseName);
        } catch (HouseNotFoundException e) {
            iHouseRepository.addHouse(house);
        }

    }

    @Override
    public void addDistrict(DistrictDTO districtDTO) throws ExistingDistrictException  {
        District district = iDistricMapper.districtDTOToDistrict(districtDTO);
        String districtName = district.getDistric_name();
        try {
            District district1 = iDistrictRepository.findDistrictByName(districtName);
            throw new ExistingDistrictException(districtName);
        } catch (DistrictNotFoundException e) {
            iDistrictRepository.addDistrict(district);
        }
    }

    @Override
    public ResponseHouseDTO calculateAllRequirements(String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseHouseDTO(name, this.calculateM2(name), this.calculatePrice(name),
                this.biggestEnvironment(name), this.environmentM2(name));
    }

    @Override
    public HouseM2DTO getM2(String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new HouseM2DTO(name,this.calculateM2(name));
    }

    @Override
    public HousePriceDTO getPrice(String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new HousePriceDTO(name,this.calculatePrice(name));
    }

    @Override
    public HouseBiggestEnvironmentDTO getBiggestEnvironment(String name) throws HouseNotFoundException, DistrictNotFoundException {
        return new HouseBiggestEnvironmentDTO(name,this.biggestEnvironment(name));
    }

    @Override
    public HouseListEnvironmentDTO getListEnvironmentWhitM2(String name) throws HouseNotFoundException{
        return new HouseListEnvironmentDTO(name,this.environmentM2(name));
    }

}
