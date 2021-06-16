package com.desafrio2.Desafio1.Repository;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.District;

public interface IPropRepository {
    District getDistrictByName(String name) throws DistrictNotExist;
}
