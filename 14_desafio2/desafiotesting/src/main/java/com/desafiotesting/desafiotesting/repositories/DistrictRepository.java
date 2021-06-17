package com.desafiotesting.desafiotesting.repositories;
import com.desafiotesting.desafiotesting.exceptions.DistrictNotFoundException;
import com.desafiotesting.desafiotesting.models.District;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository implements IDistrictRepository{

    List<District> districts = new ArrayList<>();

    public DistrictRepository(){
        districts.add(
                new District(
                "District1",
                        225.5
                ));
        districts.add(new District(
                        "District2",
                235.5
                )
        );
    }

    @Override
    public District findByName(String name) {
        District founded = districts.stream()
                .filter(district -> district.getName().equals(name))
                .findFirst().orElseThrow(()-> new DistrictNotFoundException("El barrio " + name + " no existe" , HttpStatus.NOT_FOUND));
        return founded;
    }


}
