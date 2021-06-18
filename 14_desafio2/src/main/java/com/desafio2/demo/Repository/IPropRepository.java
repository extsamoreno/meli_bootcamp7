package com.desafio2.demo.Repository;

import com.desafio2.demo.Model.District;
import com.desafio2.demo.Exception.DistrictNotExistException;

public interface IPropRepository {
    District getDistrictByName(String name) throws DistrictNotExistException;
}
