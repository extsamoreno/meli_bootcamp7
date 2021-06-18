package com.example.demo;

import com.example.demo.model.District;
import com.example.demo.model.Environment;
import com.example.demo.dtos.*;
import com.example.demo.model.Property;

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

         propertyM2EnvsResponseDTO.setProp_name("Prop1");
         EnvironmentM2DTO environmentM2DTO1 = new EnvironmentM2DTO("Environment1",51d);
         EnvironmentM2DTO environmentM2DTO2 = new EnvironmentM2DTO("Environment2",42d);
         EnvironmentM2DTO environmentM2DTO3 = new EnvironmentM2DTO("Environment3",56d);

         environmentM2DTOList.add(environmentM2DTO1);
         environmentM2DTOList.add(environmentM2DTO2);
         environmentM2DTOList.add(environmentM2DTO3);
         propertyM2EnvsResponseDTO.setEnviroments(environmentM2DTOList);

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


         propertyRequestDTO.setProp_name("Prop Leo");
         propertyRequestDTO.setDistrict(districtDTO);
         propertyRequestDTO.setEnvironment(environmentRequestDTOList);

         return propertyRequestDTO;

     }


         public static Property getProperty(){
          ArrayList<Environment> environments = new ArrayList<>();
          int id=1;
             Environment env1 = new Environment("Enviroment1",5d,10d);
             Environment env2 = new Environment("Enviroment2",6d,7d);
             Environment env3 = new Environment("Enviroment3",7d,8d);
             District district = new District(1,"District1",500d);
             Property prop1 = new Property(1,"Prop1",district,null);

                 environments.add(env1);
                 environments.add(env2);
                 environments.add(env3);
                 prop1.setEnvironments(environments);

                 return prop1;
         }

         public static DistrictDTO getDistrictDTO(){
            DistrictDTO districtDTO = new DistrictDTO(1,"District1",500d);

            return districtDTO;
         }

    public static DistrictRequestDTO getDistrictRequestDTO(){
        DistrictRequestDTO districtRequestDTO = new DistrictRequestDTO("District1",500d);

        return districtRequestDTO;
    }
}
