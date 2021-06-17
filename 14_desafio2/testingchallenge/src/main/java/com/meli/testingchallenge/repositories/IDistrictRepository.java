package com.meli.testingchallenge.repositories;

import com.meli.testingchallenge.exceptions.ExistentDistrictNameException;
import com.meli.testingchallenge.models.District;

public interface IDistrictRepository {

    public District findDistrictByName(String name);

    void addDistrict(District district) throws ExistentDistrictNameException;
}
