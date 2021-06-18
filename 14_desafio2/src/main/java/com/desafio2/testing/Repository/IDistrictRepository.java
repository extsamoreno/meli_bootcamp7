package com.desafio2.testing.Repository;

import com.desafio2.testing.Model.DistrictModel;

public interface IDistrictRepository {

    DistrictModel getDistrictByName(String name);
    boolean addDistrict(DistrictModel disctrict);

}
