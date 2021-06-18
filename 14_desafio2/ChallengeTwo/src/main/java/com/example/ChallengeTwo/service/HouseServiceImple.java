package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.*;
import com.example.ChallengeTwo.exception.*;
import com.example.ChallengeTwo.mapper.MapperEnvironment;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImple implements  IHouseService{
    @Autowired
    IHouseRepository iHouseRepository;

    public double calculateTotalArea(House house){
        double totalArea=0;
        for (Environment room: house.getListEnvironment()) {
            totalArea+=room.getTotalArea();
        }
        return totalArea;
    }

    public  double calculateTotalValue(House house){
        return calculateTotalArea(house)*house.getDistric().getDistricPrice();
    }

    public Environment getBiggerEnvironment(House house){
        Environment biggerEnvironment = null;
        double aux =0;
        for (Environment environment:house.getListEnvironment()) {
            if(environment.getTotalArea() > aux){
                aux= environment.getTotalArea();
                biggerEnvironment=environment;
            }
        }
        return biggerEnvironment;
    }
    public District getDistricByName(String districName){
        return iHouseRepository.getDistricByName(districName);
    }

    @Override
    public HouseTotalAreaDTO getTotalAreaHouse(String houseName) throws ProgramException {
        House house = iHouseRepository.getHouseByName(houseName);
        //Exception
        if (house == null) throw new HouseNameNotFoundException(houseName);

        return MapperHouse.toHouseTotalAreaDTO(house, calculateTotalArea(house));
    }

    @Override
    public HouseTotalValueDTO getTotalValueHouse(String houseName) throws HouseNameNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        //Exception
        if (house == null) throw new HouseNameNotFoundException(houseName);

        return  MapperHouse.toHouseTotalValueDTO(house,calculateTotalArea(house),calculateTotalValue(house));
    }

    @Override
    public BiggestEnvironmentDTO getBiggestEnviroment(String houseName) throws HouseNameNotFoundException {
        House house = iHouseRepository.getHouseByName(houseName);
        //Exception
        if (house == null) throw new HouseNameNotFoundException(houseName);

        return MapperEnvironment.toBiggerEnvironment(getBiggerEnvironment(house),houseName);
    }

    @Override
    public List<EnvironmentAreaDTO> getAllEnviromentsArea(String houseName) throws HouseNameNotFoundException {

        House house = iHouseRepository.getHouseByName(houseName);
        //Exception
        if (house == null) throw new HouseNameNotFoundException(houseName);
        List<EnvironmentAreaDTO> listResult = new ArrayList<>();
        for(Environment environment: house.getListEnvironment()){
            listResult.add(MapperEnvironment.toEnvironmentAreaDTO(environment));
        }
        return listResult;
    }
    @Override
    public String createNewHouse(HouseDTO house) throws ProgramException {
        District district = getDistricByName(house.getDistricName());
        //Exeptions
        if(district==null) throw new DistrictNameNotFoundException(house.getDistricName());
        if(iHouseRepository.existsHouse(MapperHouse.toHouse(house,district))) throw new HouseAlreadyExistsException(house.getHouseName());

        House houseAdd = MapperHouse.toHouse(house,district);
        return iHouseRepository.addNewHouse(houseAdd);
    }

    @Override
    public String createNewDistrict(DistrictDTO districtDTO) throws DistrictAlreadyExistsException {

        District district = new District(districtDTO.getDistrictName(),districtDTO.getPrice());
        //Exceptions
        if(iHouseRepository.existsDistrict(new District(district.getDistricName(),district.getDistricPrice()))) {
            throw new DistrictAlreadyExistsException(district.getDistricName());
        }

        return iHouseRepository.addNewDistrict(district);
    }


}
