package com.meli.tucasita.repository;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.model.District;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DistrictRepository implements IDistrictRepository{
    public static Map<String, District> districts= new HashMap<>();
    static {
        districts.put("Fontibon", new District("Fontibon",2000));
        districts.put("Kennedy", new District("Kennedy",1500));
        districts.put("Santa Fe", new District("Santa Fe",1300));
        districts.put("Suba", new District("Suba", 800));
        districts.put("Bosa", new District("Bosa",950));
    }

    @Override
    public District getDistrictByName(String name) throws DistrictNotFoundException {
        District d= districts.get(name);
        if (d==null){
            throw new DistrictNotFoundException(name);
        }
        return d;
    }
}
