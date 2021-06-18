package com.desafio2.testing.Repository;


import com.desafio2.testing.Model.DistrictModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DistrictRepository implements IDistrictRepository {

    private static ArrayList<DistrictModel> districtDataBase = new ArrayList<>();


    @Override
    public DistrictModel getDistrictByName(String name) {
        for (DistrictModel b : districtDataBase) {
            if (b.getDistrict_name().equals(name)) {
                return b;
            }
        }
        return null;
    }


    public boolean addDistrict(DistrictModel disctrict){
        return districtDataBase.add(disctrict);
    }


}
