package com.example.demo;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.District;
import com.example.demo.model.Environment;
import com.example.demo.services.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Environment BiggestEnvironment(List<Environment> environmentList){

        Environment biggestEnvironment = null;

        for(Environment environment:environmentList){
            if(biggestEnvironment==null){
                biggestEnvironment = environment;
            }else{
                double mayor = biggestEnvironment.getEnvironment_length()*biggestEnvironment.getEnvironment_width();
                double comparar = environment.getEnvironment_length()*environment.getEnvironment_width();
                if(comparar > mayor){
                    biggestEnvironment = environment;
                }
            }
        }

        return biggestEnvironment;
    }

    public static PropertyM2ResponseDTO getPropertyM2ResponseDTO(){
        PropertyM2ResponseDTO propertyM2ResponseDTO = new PropertyM2ResponseDTO();

        propertyM2ResponseDTO.setProp_name("Prop1");
        propertyM2ResponseDTO.setProp_square_meters(148d);

        return propertyM2ResponseDTO;
    }
    public static PropertyPriceResponseDTO getPropertyPriceResponseDTO(){
        PropertyPriceResponseDTO propertyPriceResponseDTO = new PropertyPriceResponseDTO();
        ArrayList<EnvironmentDTO> environments = new ArrayList<>();

        EnvironmentDTO env1 = new EnvironmentDTO("Enviroment1",50d,25000d);
        EnvironmentDTO env2 = new EnvironmentDTO("Enviroment2",42d,21000d);
        EnvironmentDTO env3 = new EnvironmentDTO("Enviroment3",56d,28000d);

        environments.add(env1);
        environments.add(env2);
        environments.add(env3);

        propertyPriceResponseDTO.setProp_name("Prop1");
        propertyPriceResponseDTO.setProp_price(74000d);

        propertyPriceResponseDTO.setEnviroments(environments);

        return propertyPriceResponseDTO;
    }

     public static BiggestPropResponseDTO getBiggestEnvPropDTO(){
         BiggestPropResponseDTO biggestPropResponseDTO = new BiggestPropResponseDTO();
         BiggestEnvironmentDTO biggestEnvironmentDTO = new BiggestEnvironmentDTO();

         biggestPropResponseDTO.setProp_name("Prop1");
         biggestEnvironmentDTO.setEnvironment_name("Environment3");
         biggestEnvironmentDTO.setSquare_meters(56d);

         biggestPropResponseDTO.setBiggestEnvironment(biggestEnvironmentDTO);

         return biggestPropResponseDTO;
     }

     public static PropertyM2EnvsResponseDTO getSquareMetersEnvDTO(){
         PropertyM2EnvsResponseDTO propertyM2EnvsResponseDTO = new PropertyM2EnvsResponseDTO();
         List<EnvironmentM2DTO> environmentM2DTOList = new ArrayList<>();

         EnvironmentM2DTO environmentM2DTO1 = new EnvironmentM2DTO("Environment1",50d);
         EnvironmentM2DTO environmentM2DTO2 = new EnvironmentM2DTO("Environment2",42d);
         EnvironmentM2DTO environmentM2DTO3 = new EnvironmentM2DTO("Environment3",56d);

         environmentM2DTOList.add(environmentM2DTO1);
         environmentM2DTOList.add(environmentM2DTO2);
         environmentM2DTOList.add(environmentM2DTO3);

         return propertyM2EnvsResponseDTO;
     }

     public static PropertyRequestDTO getPropertyRequestDTO(){
         PropertyRequestDTO propertyRequestDTO = new PropertyRequestDTO();
         DistrictDTO districtDTO = new DistrictDTO(1,"District1",500d);
         List<EnvironmentRequestDTO> environmentRequestDTOList = new ArrayList<>();

         EnvironmentRequestDTO environmentRequestDTO1 = new EnvironmentRequestDTO("Environment1",5d,4d);
         EnvironmentRequestDTO environmentRequestDTO2 = new EnvironmentRequestDTO("Environment2",4d,4d);
         EnvironmentRequestDTO environmentRequestDTO3 = new EnvironmentRequestDTO("Environment3",3d,3d);

         environmentRequestDTOList.add(environmentRequestDTO1);
         environmentRequestDTOList.add(environmentRequestDTO2);
         environmentRequestDTOList.add(environmentRequestDTO3);


         propertyRequestDTO.setProp_name("Propleo");
         propertyRequestDTO.setDistrict(districtDTO);
         propertyRequestDTO.setEnvironment(environmentRequestDTOList);

         return propertyRequestDTO;

     }

}
