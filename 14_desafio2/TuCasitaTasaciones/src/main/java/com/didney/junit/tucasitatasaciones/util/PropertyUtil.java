package com.didney.junit.tucasitatasaciones.util;

import com.didney.junit.tucasitatasaciones.dto.response.*;
import com.didney.junit.tucasitatasaciones.mapper.EnvironmentMapper;
import com.didney.junit.tucasitatasaciones.model.Environment;
import com.didney.junit.tucasitatasaciones.model.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyUtil {

    public TotalSquareMeterPropertyDTOResponse getTotalMeterSquare(Property property) {
        double totalSquareMeter = 0.0;
        for (Environment obj : property.getEnvironments()) {
            totalSquareMeter += obj.getEnvironmentWidth() * obj.getEnvironmentLength();
        }
        return new TotalSquareMeterPropertyDTOResponse(property.getPropName(), totalSquareMeter);
    }

    public TotalValuePropertyByEnvironmentDTOResponse getTotalValueProperty(Property property) {
        var t = getTotalMeterSquare(property);
        return new TotalValuePropertyByEnvironmentDTOResponse(t.getPropertyName(), (t.getTotalMeterSquare() * property.getDistrict().getDistrictPrice()));
    }

    public EnvironmentDTOResponse getBiggerEnvironment(Property property) {
        double bigger = 0;
        List<Environment> environments = new ArrayList<>();
        for (Environment obj : property.getEnvironments()) {
            double value = (obj.getEnvironmentWidth() * obj.getEnvironmentLength());
            if (bigger < value) {
                environments.clear();
                environments.add(obj);
                bigger = value;
            } else if (bigger == value)
                environments.add(obj);
        }
        return new EnvironmentDTOResponse(property.getPropName(), new EnvironmentMapper().environmentToListEnvironmentDTO(environments));
    }

    public TotalSquareMeterByEnvironmentDTOResponse getEnvironmentSquareMeter(Property property) {
        List<EnvironmentSquareMeterDTOResponse> environments = new ArrayList<>();
        for (Environment obj : property.getEnvironments()) {
            environments.add(new EnvironmentSquareMeterDTOResponse(obj.getEnvironmentName(), obj.getEnvironmentLength() * obj.getEnvironmentWidth()));
        }
        return new TotalSquareMeterByEnvironmentDTOResponse(property.getPropName(), environments);
    }
}
