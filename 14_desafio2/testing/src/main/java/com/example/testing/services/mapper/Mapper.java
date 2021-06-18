package com.example.testing.services.mapper;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.dto.PropertyDTO;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;
import com.example.testing.services.IPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Mapper {

    public EnvironmentDTO toDTO(Environment e){
        return new EnvironmentDTO(e.getName(), e.getSquareMeters());
    }

    public ArrayList<EnvironmentDTO> listToDTO(ArrayList<Environment> environments){
        ArrayList<EnvironmentDTO> environmentDTOS = new ArrayList<>();

        for (Environment e: environments) {
            environmentDTOS.add(toDTO(e));
        }

        return environmentDTOS;
    }


}
