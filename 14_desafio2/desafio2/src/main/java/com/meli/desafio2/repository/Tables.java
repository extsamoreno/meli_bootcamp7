package com.meli.desafio2.repository;

import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.EnviromentDTO;
import com.meli.desafio2.dto.PropertyDTO;

import java.util.ArrayList;

public class Tables {
    private static ArrayList<PropertyDTO> propertyList = new ArrayList<>();
    private static ArrayList<DistrictDTO> districtList = new ArrayList<>();

    public static void fillDB(){
        DistrictDTO district1;
        ArrayList<EnviromentDTO> enviromentList1 = new ArrayList<>();
        enviromentList1.add(new EnviromentDTO("Dormitorio_1",5,6));
        enviromentList1.add(new EnviromentDTO("Dormitorio_2",3,5));
        enviromentList1.add(new EnviromentDTO("Cocina",5,5));
        district1 = new DistrictDTO(-1,"Klee",160.0);
        addProperty(new PropertyDTO(-1,"Departamento1",addDistrict(district1),enviromentList1));

        DistrictDTO district2;
        ArrayList<EnviromentDTO> enviromentList2 = new ArrayList<>();
        enviromentList2.add(new EnviromentDTO("Dormitorio",3,4));
        enviromentList2.add(new EnviromentDTO("Living",7,8));
        enviromentList2.add(new EnviromentDTO("Comedor",6,5));
        district2 = new DistrictDTO(-1,"Qiqi",160.0);
        addProperty(new PropertyDTO(-1,"Departamento2",addDistrict(district2),enviromentList2));

        DistrictDTO district3;
        ArrayList<EnviromentDTO> enviromentList3 = new ArrayList<>();
        enviromentList3.add(new EnviromentDTO("Cocina",6,4));
        enviromentList3.add(new EnviromentDTO("Dormitorio",3,5));
        district3 = new DistrictDTO(-1,"Diona",160.0);
        addProperty(new PropertyDTO(-1,"Departamento3",addDistrict(district3),enviromentList3));
    }

    public static int addProperty(PropertyDTO property){
        property.setProp_id(nextPropertyId());
        propertyList.add(property);
        return property.getProp_id();
    }

    public static int addDistrict(DistrictDTO district){
        district.setDistrict_id(nextDistrictId());
        districtList.add(district);
        return district.getDistrict_id();
    }

    private static int nextPropertyId() {
        int id=1;
        for (PropertyDTO a:propertyList) {
            if (a.getProp_id()>=id){
                id=a.getProp_id()+1;
            }
        }
        return id;
    }

    private static int nextDistrictId() {
        int id=1;
        for (DistrictDTO a:districtList) {
            if (a.getDistrict_id()>=id){
                id=a.getDistrict_id()+1;
            }
        }
        return id;
    }

    public static PropertyDTO getPropertyByid(int id){
        for (PropertyDTO property:propertyList) {
            if(property.getProp_id()==id){
                return property;
            }
        }
        return null;
    }

    public static DistrictDTO getDistrictByid(int id){
        for (DistrictDTO district:districtList) {
            if(district.getDistrict_id()==id){
                return district;
            }
        }
        return null;
    }

    public static DistrictDTO getDistrictByName(String districtName) {
        for (DistrictDTO district:districtList) {
            if(district.getDistrict_name().equals(districtName)){
                return district;
            }
        }
        return null;
    }
}
