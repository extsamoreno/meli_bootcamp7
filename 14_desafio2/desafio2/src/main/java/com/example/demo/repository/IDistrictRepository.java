package com.example.demo.repository;

import com.example.demo.models.District;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistrictRepository {
    public District findDistrictByName(String name);
}
