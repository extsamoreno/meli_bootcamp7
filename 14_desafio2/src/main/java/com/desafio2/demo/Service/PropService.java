package com.desafio2.demo.Service;

import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Model.District;
import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.Environment;
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
    public PropDTOTPrice priceProp(PropRequest prop) throws DistrictNotExist {
        District district = iPropRequestRepository.getDistrictByName(prop.getDistrictName());
        double totalPrice = district.getPricePorMeter2() * totalArea(prop);
        return propMapper.toDTOPrice(prop, totalPrice);
    }

    public List<EnvironmentDTO> bigEnvironment(PropRequest prop) {
        double maxArea = maxArea(prop);
        //Check if there are varius enviroment with the same area
        List<EnvironmentDTO> listEnv = prop.getEnvironments().stream().filter(e-> e.area() == maxArea)
                .map(env -> propMapper.toEnvDTO(env)).collect(Collectors.toList());
        return listEnv;
    }

    @Override
    public PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop) {
        return propMapper.toPropByMeter(prop);
    }

    private double totalArea(PropRequest prop){
        return prop.getEnvironments().stream()
                .mapToDouble(Environment::area).sum();
    }

    private double maxArea(PropRequest prop){
        Environment maxEnv = prop.getEnvironments().stream().max((e1, e2)-> (int) (e1.area() - e2.area())).get();
        return maxEnv.area();
    }
}