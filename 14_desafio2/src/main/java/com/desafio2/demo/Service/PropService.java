package com.desafio2.demo.Service;

import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Model.District;
import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Model.Mapper.IPropMapper;
import com.desafio2.demo.Repository.IPropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropService implements IPropService {

    @Autowired
    IPropRepository iPropRequestRepository;

    @Autowired
    IPropMapper propMapper;

    @Override
    public PropDTOTMeters totalSquareMeters(PropRequest prop) {
        return propMapper.toDTOMeters(prop, totalArea(prop));
    }

    @Override
    public PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExistException {
        District district = iPropRequestRepository.getDistrictByName(prop.getDistrictName());
        //Get totalPrice multiply  price by district and totalArea
        double totalPrice = district.getPricePorMeter2() * totalArea(prop);
        return propMapper.toDTOPrice(prop, totalPrice);
    }

    public List<EnvironmentDTOResponse> bigEnvironment(PropRequest prop) {
        double maxArea = maxArea(prop);
        //Check if there are varius enviroment with the same area
        List<EnvironmentDTOResponse> listEnv = prop.getEnvironments().stream().filter(e-> e.area() == maxArea)
                .map(env -> propMapper.toEnvDTOResponse(env, env.area())).collect(Collectors.toList());
        return listEnv;
    }

    @Override
    public PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop) {
        return propMapper.toPropByMeter(prop); }

    private double totalArea(PropRequest prop){
        //sum area by each Environments
        return prop.getEnvironments().stream()
                .mapToDouble(EnvironmentDTO::area).sum();
    }

    private double maxArea(PropRequest prop){
        //Check what is the Environment that have the max area and return max area
        EnvironmentDTO maxEnv = prop.getEnvironments().stream().max((e1, e2)-> (int) (e1.area() - e2.area())).get();
        return maxEnv.area();
    }
}