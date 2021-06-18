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
    public int create(District district){
        int id = 0;

        id = districts.size() + 1;
        district.setDistrict_id(id);
        districts.put(id, district);
        return id;
    }

    @Override
    public District getById(int id) {
        return districts.get(id);
    }

    @Override
    public boolean delete(int id){
        boolean deleted = false, before = true, after = false;

        if(getById(id) == null)
            before = false;

        districts.remove(id);

        if(getById(id) != null)
            after = true;

        if(before == true && after == false)
            deleted = true;

        return deleted;
    }


    public boolean checkDistrictExists(District district){
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
