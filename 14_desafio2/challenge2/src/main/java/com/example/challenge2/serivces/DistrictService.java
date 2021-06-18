package com.example.challenge2.serivces;

import com.example.challenge2.models.District;
import com.example.challenge2.repositories.IDistrictDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    IDistrictDAO districtDAO;
    @Override
    public District create(District district) {
        return districtDAO.save(district);
    }

}
