package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.repository.IHouseDAO;

import com.meli.tuCasita.service.dto.ResponseGetPriceDTO;
import com.meli.tuCasita.service.dto.ResponseMeter2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseDAO iHouseDAO;

    @Override
    public ResponseMeter2DTO getMeter2(Long id) throws HouseNotFoundException {
        ResponseMeter2DTO responseMeter2DTO = new ResponseMeter2DTO();

        try {
            House house = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            house.getAmbient().forEach(ambiente-> oldambiente.set(calculateSquareMeters(ambiente)+ oldambiente.get()));
            responseMeter2DTO.setHouse(house);
            responseMeter2DTO.setMeter2(oldambiente.get());
            return responseMeter2DTO;
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }
    public House getDistricto(House house) throws HouseNotFoundException {
        try {
            return iHouseDAO.findByDistrict(house.getDistrict());
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(house.getId());
        }

    }

    @Override
    public ResponseGetPriceDTO getPrice(Long id) throws HouseNotFoundException {
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        try {
            House house = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            house.getAmbient().forEach(ambiente-> oldambiente.set(calculateSquareMeters(ambiente) + oldambiente.get()));
            responseGetPriceDTO.setHouse(house);
            responseGetPriceDTO.setPrice(oldambiente.get()* house.getDistrict().getPricePerMeter2());
            return responseGetPriceDTO;
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }
    private double calculateSquareMeters(Ambient ambient) throws HouseNotFoundException {
        return ambient.getLongAmbient() * ambient.getWidthAmbient();
    }
    @Override
    public Ambient getMaxAmbient(Long id) throws HouseNotFoundException  {
        try {
            House house = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            Optional<Ambient> biggestEnv = house.getAmbient().stream().max((env1, env2) -> (int) (calculateSquareMeters(env1) - (calculateSquareMeters(env2))));
            return biggestEnv.get();
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }

    @Override
    public HashMap<String, Double> getmaxambientforambient(Long id, String nameAmbient) throws HouseNotFoundException {
        try {
            House house = iHouseDAO.findById(id);
            HashMap<String, Double> oldambiente = new HashMap<>() {
            };
            house.getAmbient().stream().filter(ambientDTO -> ambientDTO.getName().equals(nameAmbient))
                    .forEach(ambiente-> oldambiente.put(ambiente.getName(), (calculateSquareMeters(ambiente))));

            return oldambiente;
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }



    @Override
    public boolean create(House stu) throws HouseNotFoundException  {
        return iHouseDAO.save(stu);
    }

    @Override
    public House read(Long id) throws HouseNotFoundException  {
        return iHouseDAO.findById(id);
    }

}
