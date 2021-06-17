package com.desafiotesting.desafiotesting.repositories;
import com.desafiotesting.desafiotesting.models.District;

public interface IDistrictRepository {
    public District findByName(String name);
}
