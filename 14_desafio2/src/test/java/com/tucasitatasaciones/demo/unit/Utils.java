package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.dto.EnvironmentDTO;
import com.tucasitatasaciones.demo.dto.PropertyDTO;
import com.tucasitatasaciones.demo.models.Environment;
import com.tucasitatasaciones.demo.models.Property;

import java.util.Arrays;

public class Utils {

    public static PropertyDTO getPropertyDTO(){
        return new PropertyDTO(1, "Las fincas", 3,
                Arrays.asList(
                        new EnvironmentDTO("Baño", 15.5, 25.0),
                        new EnvironmentDTO("Cocina", 20.5, 25.0),
                        new EnvironmentDTO("Habitacion", 20.0, 30.0)));
    }

    public static Property getProperty(){
        return new Property(1,"Las fincas", 3,
                Arrays.asList(
                        new Environment("Baño", 15.5, 25.0),
                        new Environment("Cocina", 20.5, 25.0),
                        new Environment("Habitacion", 20.0, 30.0)));
    }
}
