package com.tucasitaTasaciones.repository;

import com.tucasitaTasaciones.model.District;

public interface IDistrictRepository {

    public District findDistrictByName(String name);

}
