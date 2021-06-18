package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.DistrictNotFoundException;
import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.HouseDTO;
import com.meli.tuCasita.repository.IHouseDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseDAO iHouseDAO;

    @Override
    public Double getMeter2(Long id) throws HouseNotFoundException {
        try {
            HouseDTO houseDTO = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            houseDTO.getAmbient().forEach(ambiente-> oldambiente.set(calculateSquareMeters(ambiente)+ oldambiente.get()));
            return oldambiente.get();
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }
    public HouseDTO getDistricto(HouseDTO houseDTO) throws HouseNotFoundException {
        try {
            return iHouseDAO.findByDistrict(houseDTO.getDistrict());
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(houseDTO.getId());
        }

    }

    @Override
    public Double getPrice(Long id) throws HouseNotFoundException {
        try {
            HouseDTO houseDTO = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            houseDTO.getAmbient().forEach(ambiente-> oldambiente.set(calculateSquareMeters(ambiente) + oldambiente.get()));
            return oldambiente.get()* houseDTO.getDistrict().getPricePerMeter2();
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }
    private double calculateSquareMeters(AmbientDTO ambientDTO) throws HouseNotFoundException {
        return ambientDTO.getLongAmbient() * ambientDTO.getWidthAmbient();
    }
    @Override
    public AmbientDTO getMaxAmbient(Long id) throws HouseNotFoundException  {
        try {
            HouseDTO houseDTO = iHouseDAO.findById(id);
            AtomicReference<Double> oldambiente = new AtomicReference<>((double) 0);
            Optional<AmbientDTO> biggestEnv = houseDTO.getAmbient().stream().max((env1, env2) -> (int) (calculateSquareMeters(env1) - (calculateSquareMeters(env2))));
            return biggestEnv.get();
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }

    @Override
    public HashMap<String, Double> getmaxambientforambient(Long id, String nameAmbient) throws HouseNotFoundException {
        try {
            HouseDTO houseDTO = iHouseDAO.findById(id);
            HashMap<String, Double> oldambiente = new HashMap<>() {
            };
            houseDTO.getAmbient().stream().filter(ambientDTO -> ambientDTO.getName().equals(nameAmbient))
                    .forEach(ambiente-> oldambiente.put(ambiente.getName(), (calculateSquareMeters(ambiente))));

            return oldambiente;
        }catch (HouseNotFoundException houseNotFoundException){
            throw new HouseNotFoundException(id);
        }

    }



    @Override
    public boolean create(HouseDTO stu) throws HouseNotFoundException  {
        return iHouseDAO.save(stu);
    }

    @Override
    public HouseDTO read(Long id) throws HouseNotFoundException  {
        return iHouseDAO.findById(id);
    }

}
