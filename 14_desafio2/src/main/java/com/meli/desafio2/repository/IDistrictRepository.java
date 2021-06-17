package com.meli.desafio2.repository;

import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.model.District;

public interface IDistrictRepository {

    District getDistrictbyId(Integer distId) throws DistrictIdNotFoundException;
}
