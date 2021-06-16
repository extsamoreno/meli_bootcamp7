package com.tucasitatasaciones.demo.repository;


import com.tucasitatasaciones.demo.models.District;

public interface IDistrictRepository {

    District findDistrictById(int id);
}
