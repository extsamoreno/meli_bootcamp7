package com.meli.desafio2.repository;

import com.meli.desafio2.model.District;

public interface DistrictRepository {
    District findDistrictByID(int district_id);
}
