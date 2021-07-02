package com.example.CalculadoraMetrosCuadrados.repository;

import com.example.CalculadoraMetrosCuadrados.dto.District;

public interface IDistrictRepository {
    District getDistrictByNameAndPrice(String districtName, Double districtPrice) throws NoSuchFieldException;

}
