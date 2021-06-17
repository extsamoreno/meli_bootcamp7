package com.example.DesafioTasaciones.repository;

import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.House;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IHouseRepository {
   District findDistrictByName(String name);
   void saveProperty(House house);
   House findPropertyById(Integer id);
   List<House> getAllProperties();
}
