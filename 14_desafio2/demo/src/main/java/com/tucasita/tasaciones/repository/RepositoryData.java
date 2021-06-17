package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.DTO.DistrictDTO;
import com.tucasita.tasaciones.DTO.EnvironmentDTO;
import com.tucasita.tasaciones.DTO.PropertyDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositoryData {

    public static HashMap<Integer, PropertyDTO> loadProperty(){
        HashMap<Integer, PropertyDTO> listProperty = new HashMap<>();

        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5));
        env1.add(new EnvironmentDTO("Secod Room", 8,4));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3));
        env1.add(new EnvironmentDTO("BathRoom", 3,2));
        env1.add(new EnvironmentDTO("Kitchen", 5,3));

        PropertyDTO property1 = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0);

        List<EnvironmentDTO> env2 = new ArrayList<>();
        env2.add(new EnvironmentDTO("First Room", 5,4.5));
        env2.add(new EnvironmentDTO("BathRoom", 2,2));
        env2.add(new EnvironmentDTO("Kitchen", 2,1.5));

        PropertyDTO property2 = new PropertyDTO(2,"Aparta estudio", new DistrictDTO("Bochica",200),env2,0.0);

        List<EnvironmentDTO> env3 = new ArrayList<>();
        env3.add(new EnvironmentDTO("First Room", 15,9));
        env3.add(new EnvironmentDTO("Secod Room", 10,8.5));
        env3.add(new EnvironmentDTO("Lobby", 5,7));
        env3.add(new EnvironmentDTO("Sala", 4,3));
        env3.add(new EnvironmentDTO("BathRoom", 3,2));
        env3.add(new EnvironmentDTO("Kitchen", 7,4));

        PropertyDTO property3 = new PropertyDTO(3,"Casa familiar", new DistrictDTO("Colina",1000),env3,0.0);

        listProperty.put(1,property1);
        listProperty.put(2,property2);
        listProperty.put(3,property3);

        return listProperty;

    }

    public static HashMap<String, DistrictDTO> loadDistrict(){

        HashMap<String, DistrictDTO> listDistrict = new HashMap<>();

        listDistrict.put("Chico", new DistrictDTO("Chico",500));
        listDistrict.put("Bochica", new DistrictDTO("Bochica",200));
        listDistrict.put("Colina", new DistrictDTO("Colina",1000));
        listDistrict.put("ParkWay", new DistrictDTO("ParkWay",700));

        return listDistrict;

    }
}
