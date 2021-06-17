package com.TuCasitaTasacionesAPI.TuCasita;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.*;
import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;

import java.util.ArrayList;
import java.util.List;

public class UtilsDataTests {

    public static Property generateProperty(){
        Property prop1 = new Property(1, "Av. Marquez 123", 1, new ArrayList<>());
        Environment e1_prop1 = new Environment("Cocina", 7.0, 4.0);
        Environment e2_prop1 = new Environment("Living", 4.0, 4.0);
        Environment e3_prop1 = new Environment("Comedor", 5.0, 4.0);
        prop1.getEnvironments().add(e1_prop1);
        prop1.getEnvironments().add(e2_prop1);
        prop1.getEnvironments().add(e3_prop1);

        return prop1;
    }

    public static Environment generateEnvironment(){
        return  new Environment("Cocina", 7.0, 4.0);
    }

    public static EnvironmentDTO generateEnvironmentDTO(){
        return  new EnvironmentDTO("Cocina", 7.0, 4.0);
    }

    public static List<EnvironmentM2DTO> generateListEnviroments(){
        List<EnvironmentM2DTO> listEnvironmentM2DTO = new ArrayList<>();
        listEnvironmentM2DTO.add(new EnvironmentM2DTO("Cocina", 28.0));
        listEnvironmentM2DTO.add(new EnvironmentM2DTO("Living", 16.0));
        listEnvironmentM2DTO.add(new EnvironmentM2DTO("Comedor", 20.0));
        return listEnvironmentM2DTO;
    }

    public static EnvironmentBiggestDTO generateEnvironmentBiggestDto(){
        return new EnvironmentBiggestDTO(
                new EnvironmentDTO("Cocina" , 7.0,4.0 ));
    }

    public static PricePropertyDTO generatePricePropertyDTO(){
        return new PricePropertyDTO("Av. Marquez 123", 12800.0);
    }

    public static TotalM2DTO generateTotalM2DTO(){
        return new TotalM2DTO("Av. Marquez 123", 64.0);
    }


}
