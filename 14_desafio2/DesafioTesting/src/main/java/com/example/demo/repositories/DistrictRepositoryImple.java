package com.example.demo.repositories;

import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.model.District;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;
import com.example.demo.services.mappers.MapperDistrict;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepositoryImple implements DistrictRepository{

    private List<District> districtList = new ArrayList<>();
    private int id=0;

    @Override
    public DistrictRequestDTO createDistrict(DistrictRequestDTO districtRequestDTO) {
        District district;

        district = MapperDistrict.toDistrict(districtRequestDTO);
        district.setDistrict_id(id++);
        districtList.add(district);

        return districtRequestDTO;
    }

    @Override
    public void loadData() {
        District district = new District();
        district.setDistrict_id(++id);
        district.setDistrict_name("District1");
        district.setDistrict_price(500d);
        districtList.add(district);
    }

    @Override
    public DistrictDTO findDistrictById(int disId) throws DistrictDontFoundException {
        DistrictDTO districtDTO = null;

        for(District district:districtList){
            if( district.getDistrict_id() == disId){
                districtDTO = MapperDistrict.toDistrictDTO(district);
            }
        }

        if(districtDTO == null){
             throw new DistrictDontFoundException(disId);
        }
        return districtDTO;
    }
}
