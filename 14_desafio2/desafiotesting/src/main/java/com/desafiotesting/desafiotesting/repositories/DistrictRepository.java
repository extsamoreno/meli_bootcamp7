package com.desafiotesting.desafiotesting.repositories;
import com.desafiotesting.desafiotesting.models.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DistrictRepository implements IDistrictRepository{

    List<District> districts = new ArrayList<>();

    public DistrictRepository(){
        districts.add(
                new District(
                "El challao",
                200.0
                ));
        districts.add(new District(
                        "Chacras",
                        250.0
                )
        );
    }

    @Override
    public District findByName(String name) {
        District founded = districts.stream()
                .filter(district -> district.getName().equals(name))
                .findFirst().orElse(null);
        return founded;
    }


}
