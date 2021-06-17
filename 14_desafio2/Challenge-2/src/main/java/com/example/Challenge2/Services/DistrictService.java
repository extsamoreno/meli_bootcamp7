package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    IDataRepository iDataRepository;


    private District getDistrictById(Long id) throws DistrictNotFoundException {
        District district = iDataRepository.getDistrictById(id);

        if(district != null){
            return district;
        }
        else {
            throw new DistrictNotFoundException(id);
        }
    }


    @Override
    public Boolean storeDistrict(DistrictDTO district)  {

        Long id = this.genPropertyID();
        District newDistrict = DistrictMapper.toDistrict(district);
        newDistrict.setId(id);

        iDataRepository.getAllDistricts().add(newDistrict);

        return  true;

    }


    private Long genPropertyID(){
        Long id = new Long(iDataRepository.getAllDistricts().size());
        Boolean validId = false;
        while(!validId){

            try{
                this.getDistrictById(id);
                id++;
            }
            catch (DistrictNotFoundException e){
                validId = true;
            }
        }

        return id;
    }


}
