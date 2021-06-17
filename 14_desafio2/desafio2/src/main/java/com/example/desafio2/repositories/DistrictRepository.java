package com.example.desafio2.repositories;

import com.example.desafio2.models.District;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DistrictRepository implements IDistrictRepository{
    HashMap<Integer,District> districtHm = new HashMap<>();

    @Override
    public int add(District district) {
        try{
            districtHm.put(districtHm.size()+1,district);
            listDistricts();
        }catch (Exception e){
            throw e;
        }
        return districtHm.size();
    }

    @Override
    public District getById(int id) {
        return districtHm.get(id);
    }


    private void listDistricts(){
        districtHm.forEach((a,b)->{
            System.out.println(b.toString());
        });
    }
}
