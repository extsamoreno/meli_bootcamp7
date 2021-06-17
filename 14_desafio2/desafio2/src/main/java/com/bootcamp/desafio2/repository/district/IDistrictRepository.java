package com.bootcamp.desafio2.repository.district;

public interface IDistrictRepository {

    boolean existsDistrictInDB(String district_name);

    Double getDistrictPrice(String district_name);
}
