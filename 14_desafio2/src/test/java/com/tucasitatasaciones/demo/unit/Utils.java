package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Environment;
import com.tucasitatasaciones.demo.models.Property;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static PropertyDTO getPropertyDTO(){
        return new PropertyDTO(1, "Las fincas", 3,
                Arrays.asList(
                        new EnvironmentDTO("Comedor", 15.5, 25.0),
                        new EnvironmentDTO("Cocina", 20.5, 25.0),
                        new EnvironmentDTO("Habitacion", 20.0, 30.0)));
    }

    public static Property getProperty(){
        return new Property(1,"Las fincas", 3,
                Arrays.asList(
                        new Environment("Comedor", 15.5, 25.0),
                        new Environment("Cocina", 20.5, 25.0),
                        new Environment("Habitacion", 20.0, 30.0)));
    }

    public static PropertySquareMettersDTO getPropertySquareMetters(){
        return new PropertySquareMettersDTO(1, "Las fincas", 1500);
    }

    public static PropertyPriceDTO getPropertyPrice(){
        return new PropertyPriceDTO(1, "Las fincas", 113850.00000000001);
    }

    public static PropertyBiggestEnvironmentDTO getPropertyBiggestEnvironment(){
        EnvironmentDTO environmentExpected = new EnvironmentDTO("Habitacion", 20, 30);
        return new PropertyBiggestEnvironmentDTO(1, "Las fincas", environmentExpected);
    }

    public static PropertyEnvironmentSquareMetterDTO getPropertyEnviromentsSquareMetters(){
        ArrayList<EnvironmentSquareMetterDTO> environmentsExpected = new ArrayList<>();
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Comedor", 15.5, 25.0, 387.5));
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Cocina", 20.5, 25.0, 512.5));
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Habitacion", 20.0, 30.0, 600));
        return new PropertyEnvironmentSquareMetterDTO(1, "Las fincas", environmentsExpected);
    }

    public static District getDistrict(){
        return new District(3, "Nueva Cordoba", 55);
    }

    public static DistrictDTO getDistrictDTO(){
        return new DistrictDTO(3, "Nueva Cordoba", 20);
    }
}
