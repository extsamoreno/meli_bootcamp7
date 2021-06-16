package com.meli.desafio2.web.repository;

import com.meli.desafio2.web.model.District;

public interface IDistrictRepository {
    public District getDistrictByName(String name);
}
