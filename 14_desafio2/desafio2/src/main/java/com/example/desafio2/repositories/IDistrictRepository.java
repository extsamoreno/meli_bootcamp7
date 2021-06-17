package com.example.desafio2.repositories;

import com.example.desafio2.models.District;

public interface IDistrictRepository {
    int add(District district);
    District getById(int id);
}
