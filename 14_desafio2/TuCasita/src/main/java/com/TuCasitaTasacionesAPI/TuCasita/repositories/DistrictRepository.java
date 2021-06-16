package com.TuCasitaTasacionesAPI.TuCasita.repositories;

import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;

import org.springframework.stereotype.Repository;



import java.util.*;

@Repository
public class DistrictRepository implements IDistrictRepository{

    private Map<Integer, District> districts;

    public DistrictRepository(){
        districts = new HashMap<>();
        this.loadData();
    }

    @Override
    public int create(District district) throws DistrictAlreadyExistsException {
        int id;

        if(checkDistrictExists(district))
            throw new DistrictAlreadyExistsException(district.getDistrict_name());
        else {
            id = districts.size() + 1;
            district.setDistrict_id(id);
            districts.put(id, district);
        }

        return id;
    }

    @Override
    public District getById(int id) throws DistrictNotFoundException {
        District district = districts.get(id);

        if(district != null)
            return district;
        else
            throw new DistrictNotFoundException(id);
    }

    private boolean checkDistrictExists(District district){
        return districts.values().stream()
                .anyMatch(x -> x.getDistrict_name().equals(district.getDistrict_name()));
    }

    //===============================
    private void loadData() {
        District d1 = new District(1, "San Isidro" , 200.0);
        District d2 = new District(2, "Vicente Lopez" , 150.0);
        District d3 = new District(3, "San Fernando" , 100.0);
        districts.put(1, d1);
        districts.put(2, d2);
        districts.put(3, d3);
    }
}
