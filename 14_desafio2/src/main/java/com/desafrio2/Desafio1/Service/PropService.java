package com.desafrio2.Desafio1.Service;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.*;
import com.desafrio2.Desafio1.Model.District;
import com.desafrio2.Desafio1.Model.Environment;
import com.desafrio2.Desafio1.Model.Mapper.IPropMapper;
import com.desafrio2.Desafio1.Repository.IPropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        District district = iPropRequestRepository.getDistrictByName(prop.getDistrict().getName());
        double totalPrice = district.getPricePorMeter2() * totalArea(prop);
        return propMapper.toDTOPrice(prop, totalPrice);
    }

    public EnvironmentDTO bigEnvironment(PropRequest prop) {
        Environment maxEnv = prop.getEnvironments().stream().max((e1, e2)-> (int) (e1.area() - e2.area())).get();
        return propMapper.toEnvDTO(maxEnv);
    }

    @Override
    public PropDTOTMeterByEnvironment meterByEnvironment(PropRequest prop) {
        return propMapper.toPropByMeter(prop);
    }

    private double totalArea(PropRequest prop){
        return prop.getEnvironments().stream()
                .mapToDouble(Environment::area).sum();
    }
}