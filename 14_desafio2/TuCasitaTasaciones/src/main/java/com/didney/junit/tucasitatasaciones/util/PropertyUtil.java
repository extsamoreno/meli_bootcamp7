package com.didney.junit.tucasitatasaciones.util;

import com.didney.junit.tucasitatasaciones.dto.response.EnvironmentSquareMeterResponse;
import com.didney.junit.tucasitatasaciones.model.Environment;
import com.didney.junit.tucasitatasaciones.model.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyUtil {
    public double getTotalMeterSquare(Property property) {
        double totalSquareMeter = 0.0;
        for (Environment obj : property.getEnvironments()) {
            totalSquareMeter += obj.getEnvironmentWidth() * obj.getEnvironmentLength();
        }
        return totalSquareMeter;
    }

    public double getTotalValueProperty(Property property) {
        return getTotalMeterSquare(property) * property.getDistrict().getDistrictPrice();
    }

    public List<Environment> getBiggerEnvironment(Property property) {
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
        return environments;
    }
    public List<EnvironmentSquareMeterResponse> getEnvironmentSquareMeter(Property property) {
        List<EnvironmentSquareMeterResponse> environments = new ArrayList<>();
        for (Environment obj : property.getEnvironments()) {
            environments.add( new EnvironmentSquareMeterResponse(obj.getEnvironmentName(),obj.getEnvironmentLength()*obj.getEnvironmentWidth()));
        }
        return environments;
    }
}
